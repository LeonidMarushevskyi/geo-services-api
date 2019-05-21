import groovy.transform.Field
@Library('jenkins-pipeline-utils') _

@Field
def GITHUB_CREDENTIALS_ID = 'fa29964d-237e-4ecb-96bc-1350dda63f79'
@Field
def deAnsibleGithubUrl = 'git@github.com:ca-cwds/de-ansible.git'

deploy('preint')
deploy('integration')

def deploy(environment) {
  node(environment) {
    try {
      checkoutStage(environment)
      rollbackDeployOnFailure('geo-services-api', environment, GITHUB_CREDENTIALS_ID, ansibleCommand(environment, env.version)) {
        deployStage(environment, env.version)
        updateManifestStage(environment, env.version)
        testsStage(environment)
      }
    } catch(Exception e) {
      currentBuild.result = 'FAILURE'
      throw e
    } finally {
      cleanWs()
    }
  }
}

def ansibleCommand(environment, version) {
  "ansible-playbook -e NEW_RELIC_AGENT=$env.USE_NEWRELIC -e GEO_API_VERSION=$version -i inventories/$environment/hosts.yml deploy-geo-services-api.yml --vault-password-file ~/.ssh/vault.txt"
}

def checkoutStage(environment) {
  stage("Checkout for $environment") {
    deleteDir()
    checkout scm
  }
}

def deployStage(environment, version) {
  stage("Deploy to $environment") {
    ws {
      environmentDashboard(addColumns: false, buildJob: '', buildNumber: version, componentName: 'Geo-Services-API', data: [], nameOfEnv: environment, packageName: 'Geo-Services-API') {
        git branch: 'master', credentialsId: GITHUB_CREDENTIALS_ID, url: deAnsibleGithubUrl
        sh ansibleCommand(environment, version)
      }
    }
  }
}

def updateManifestStage(environment, version) {
  stage("Update Manifest for $environment") {
    updateManifest('geo-services-api', environment, GITHUB_CREDENTIALS_ID, version)
  }
}

def testsStage(environment) {
  stage("Run Smoke tests on $environment") {
    def serverArti = Artifactory.newServer url: 'http://pr.dev.cwds.io/artifactory'
    def rtGradle = Artifactory.newGradleBuild()
    rtGradle.tool = "Gradle_35"
    rtGradle.resolver server: serverArti
    rtGradle.useWrapper = true
    if (environment == 'preint') {
      def gradlePropsText = """
        geoservices.api.url=https://geo.preint.cwds.io/
      """
      writeFile file: "gradle.properties", text: gradlePropsText
    } else {
      def gradlePropsText = """
        geoservices.api.url=https://geo.integration.cwds.io/
      """
      writeFile file: "gradle.properties", text: gradlePropsText
    }
    rtGradle.run buildFile: 'build.gradle', tasks: 'clean smokeTest'
    publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/smokeTest', reportFiles: 'index.html', reportName: environment + ' Test Report', reportTitles: ''])
  }
}
