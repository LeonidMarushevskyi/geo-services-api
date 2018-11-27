@Library('jenkins-pipeline-utils') _

node ('tpt2-slave'){
   def serverArti = Artifactory.server 'CWDS_DEV'
   def rtGradle = Artifactory.newGradleBuild()
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

 } catch (e)   {
       cleanWs()
	   }
}
