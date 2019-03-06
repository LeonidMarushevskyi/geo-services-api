import groovy.transform.Field
@Library('jenkins-pipeline-utils') _

@Field
def githubCredentialsId = '433ac100-b3c2-4519-b4d6-20node7c029a103b'
@Field
def deAnsibleGithubUrl = 'git@github.com:ca-cwds/de-ansible.git'

deploy('preint')
deploy('integration')

def deploy(environment) {
  node(environment) {
    try {
      checkoutStage(environment)
      deployStage(environment, env.version)
      updateManifestStage(environment, env.version)
      testsStage(environment, env.version)
    } catch(Exception e) {
      currentBuild.result = 'FAILURE'
      throw e
    } finally {
      cleanWs()
    }
  }
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
      environmentDashboard(addColumns: false, buildJob: '', buildNumber: version, componentName: 'Geo-Services-API', data: [], nameOfEnv: $environment, packageName: 'Geo-Services-API') {
        git branch: 'master', credentialsId: githubCredentialsId, url: deAnsibleGithubUrl
        sh "ansible-playbook -e NEW_RELIC_AGENT=$env.USE_NEWRELIC -e GEO_API_VERSION=$version -i inventories/$environment/hosts.yml deploy-geo-services-api.yml --vault-password-file ~/.ssh/vault.txt"
      }
    }
  }
}

def updateManifestStage(environment, version) {
  stage("Update Manifest for $environment") {
    updateManifest('geo-services-api', environment, githubCredentialsId, version)
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
    publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/smokeTest', reportFiles: 'index.html', reportName: 'Integration Test Report', reportTitles: ''])
  }
}
