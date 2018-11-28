@Library('jenkins-pipeline-utils') _

node ('tpt2-slave'){
   def serverArti = Artifactory.server 'CWDS_DEV'
   def rtGradle = Artifactory.newGradleBuild()
   if (env.BUILD_JOB_TYPE && env.BUILD_JOB_TYPE=="master" ) {
     triggerProperties = pullRequestMergedTriggerProperties('geo-services-api')
     properties([pipelineTriggers([triggerProperties]), buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')), disableConcurrentBuilds(), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false],
     parameters([
        string(defaultValue: 'latest', description: '', name: 'APP_VERSION'),
        string(defaultValue: 'master', description: '', name: 'branch'),
        booleanParam(defaultValue: false, description: 'Default release version template is: <majorVersion>_<buildNumber>-RC', name: 'RELEASE_PROJECT'),
        string(description: 'Fill this field if need to specify custom version ', name: 'OVERRIDE_VERSION'),
        booleanParam(defaultValue: true, description: '', name: 'USE_NEWRELIC'),
        string(defaultValue: 'inventories/tpt2dev/hosts.yml', description: '', name: 'inventory')
        ]), pipelineTriggers([pollSCM('H/5 * * * *')])])
  } else {
    properties([disableConcurrentBuilds(), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false],
    parameters([
       string(defaultValue: '${ghprbActualCommit}', description: '', name: 'branch'),
       string(defaultValue: 'inventories/tpt2dev/hosts.yml', description: '', name: 'inventory')
       ])])
  }
  try {
     stage('Preparation') {
		  git branch: '$branch', credentialsId: '433ac100-b3c2-4519-b4d6-207c029a103b', url: 'git@github.com:ca-cwds/geo-services-api.git'
		  rtGradle.tool = "Gradle_35"
		  rtGradle.resolver repo:'repo', server: serverArti
		  rtGradle.useWrapper = true
   }
   stage('Build'){
		def buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'readArguments jar -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
   }
   stage('Unit Tests') {
       buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'test jacocoTestReport', switches: '--stacktrace'
	     publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'JUnitReports', reportTitles: 'JUnit tests summary'])
   }
   stage('SonarQube analysis'){
	 	lint(rtGradle)
   }
	stage ('Build Docker'){
	   buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'createDockerImage -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
	}
  if (env.BUILD_JOB_TYPE && env.BUILD_JOB_TYPE=="master" ) {
    stage('Tag Git') {
        // tagRepo('test-tags')
	   sshagent(credentials: ['433ac100-b3c2-4519-b4d6-207c029a103b']) {
           def buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'pushGitTag -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
       }
    }
    stage ('Push to artifactory'){
	    rtGradle.deployer.deployArtifacts = true
	    buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'publish -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
  		rtGradle.deployer.deployArtifacts = false
	}
    stage('Push to Docker Image') {
	   withDockerRegistry([credentialsId: '6ba8d05c-ca13-4818-8329-15d41a089ec0']) {
           buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'publishDocker -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
       }
    }
	stage('Clean Workspace') {
		buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'dropDockerImage -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
		archiveArtifacts artifacts: '**/geo-services-api-*.jar,readme.txt', fingerprint: true
		cleanWs()
	}
	stage('Deploy Application'){
	   checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '433ac100-b3c2-4519-b4d6-207c029a103b', url: 'git@github.com:ca-cwds/de-ansible.git']]]
	   sh 'ansible-playbook -e NEW_RELIC_AGENT=$USE_NEWRELIC -e GEO_API_VERSION=$APP_VERSION -i $inventory deploy-geo-services-api.yml --vault-password-file ~/.ssh/vault.txt -vv'
	   cleanWs()
	   sleep (20)
  }
  stage('Integration Tests') {
      git branch: '$branch', url: 'https://github.com/ca-cwds/geo-services-api.git'
      buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'integrationTest --stacktrace'
      publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/integrationTest', reportFiles: 'index.html', reportName: 'Integration Tests Reports', reportTitles: 'Integration tests summary'])
     cleanWs()
  }
  }

 } catch (e)   {
       emailext attachLog: true, body: "Failed: ${e}", recipientProviders: [[$class: 'DevelopersRecipientProvider']],
       subject: "GEO Services API CI pipeline failed", to: "Leonid.Marushevskiy@osi.ca.gov, Alex.Kuznetsov@osi.ca.gov, Oleg.Korniichuk@osi.ca.gov, alexander.serbin@engagepoint.com, vladimir.petrusha@engagepoint.com"
       slackSend channel: "#geo-services-api", baseUrl: 'https://hooks.slack.com/services/', tokenCredentialId: 'slackmessagetpt2', message: "GEO Services API pipeline failed: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
	   publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/integrationTest', reportFiles: 'index.html', reportName: 'Integration Tests Reports', reportTitles: 'Integration tests summary'])
	   publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'JUnitReports', reportTitles: 'JUnit tests summary'])
       cleanWs()
	   }
}
