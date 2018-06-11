/**
This script, in conjunction with Jenkins config, automatically commits a new SemVer-style
tag to a GitHub repo when a pull request is closed.
Dev Notes:
Requires:
- A GitHub repo that sends pull request events via JSON webhook
    - Example: https://github.com/ca-cwds/tag-prototype/settings/hooks/28999500
    - See: github_webhook_config.jpg
    - trigger_key query param was randomly generated (for example, via password manager)
- GitHub repo must have labels "major", "minor", and "patch" applied to triggering PRs
- Pipeline Utility Steps Jenkins Plugin
- Generic Webhook Trigger Jenkins Plugin  (receives pull request events from GitHub)
    - Example: http://jenkins.dev.cwds.io:8080/view/prototyping/job/tag-prototype/configure
    - Sample Jenkins config: jenkins_generic_webhook_config.jpg 
    - Sample JSON payload: pull_request_event.json
- Approval to use (Jenkins Script Approval):
    - new java.util.LinkedHashMap
    - staticMethod org.codehaus.groovy.transform.ImmutableASTTransformation checkPropNames java.lang.Object
    - java.util.Map
*/

/**
It's hard to test this script without constantly open/closing PRs. 
Set to true to test with triggering only a build and using mock values.
*/
TEST_MODE = false 

// Used to avoid known_hosts addition, which would require each machine to have GitHub added in advance (maybe should do?)
GIT_SSH_COMMAND = 'GIT_SSH_COMMAND="ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no"'

// Globals
enum VersionIncrement { MAJOR, MINOR, PATCH }

def debug(String str) {
    echo "[DEBUG] ${str}"
}

// Returns Map of Maps containing the parsed JSON from the pull request event
def getPullRequestEvent() {
    def prEvents = null
    
    if(TEST_MODE) {
        prEvents = readJSON file: "${env.WORKSPACE}/pull_request_event.json"
        prEvents = prEvents.pull_request // Jenkins is configured to just grab the $.pull_request section -- this models that
    }
    else
        prEvents = readJSON text: env.pull_request_event

    return prEvents
}

// Takes a Map of Maps containing the parsed JSON from the pull request event
// Returns a list of label strings
def getLabels(prEvent) {
    debug("getLabels( prEvent: ${prEvent} )")

    def labels = []
    prEvent.labels.each{ labels << it.name }

    return labels
}

// Takes an array of strings (labels)
// Returns a VersionIncrement object
def getVersionIncrement(labels) {
    debug("getVersionIncrement( labels: ${labels} )")

    def versionIncrement = null
    def versionIncrementsFound = 0
    for(label in labels){
        switch(label) {
            case "major":
                versionIncrement = VersionIncrement.MAJOR               
                versionIncrementsFound++
                break
            case "minor":
                versionIncrement = VersionIncrement.MINOR
                versionIncrementsFound++
                break
            case "patch":
                versionIncrement = VersionIncrement.PATCH
                versionIncrementsFound++
                break
        }
    }

    if(versionIncrementsFound > 1)
        throw new Exception("More than one version increment label found. Please label PR with only one of 'major', 'minor', or 'patch'")

    return versionIncrement
}

// Compares two SemVer tags
// Returns -1 if tag1 is younger, 0 if equal, 1 if tag1 is newer
def compareTags(String tag1, String tag2) {
    debug("compareTags( tag1: ${tag1}, tag2: ${tag2} )")
    
    def tag1Split = tag1.tokenize('.')
    def tag2Split = tag2.tokenize('.')

    for(def index in (0..2)) {
        def result = tag1Split[index].compareTo(tag2Split[index])
        if(result != 0) {
            return result
        }
    }

    return 0
}

// Gets all the tags that match SemVer format
// Returns a list of strings (version number tags)
def getTags() {
    def gitTagOutput = sh(script: "git tag", returnStdout: true)
    debug("getTags(): git tag Output: ${gitTagOutput}")

    def tags = gitTagOutput.split("\n").findAll{ it =~ /^\d+\.\d+\.\d+$/ }
    return tags
}

// Gets a string indicating what the new tag should be in SemVer format
// Takes a list of strings in sem
// Returns a string with the new version tag
def getNewTag(List tags, VersionIncrement increment) {
    debug("getNewTag( tags: {$tags}, increment: ${increment} )")
    
    tags.sort{ x, y -> compareTags(x, y)}
    def mostRecentTag = tags.last()
    def mostRecentTagParts = mostRecentTag.tokenize('.')

    def newTagMajor = mostRecentTagParts[0].toInteger()
    def newTagMinor = mostRecentTagParts[1].toInteger()
    def newTagPatch = mostRecentTagParts[2].toInteger()

    switch(increment) {
        case VersionIncrement.MAJOR:
            newTagMajor++
            newTagMinor = 0
            newTagPatch = 0
            break
        case VersionIncrement.MINOR:
            newTagMinor++
            newTagPatch = 0
            break
        case VersionIncrement.PATCH:
            newTagPatch++
            break
    }

    def newTag = "${newTagMajor}.${newTagMinor}.${newTagPatch}"
    return newTag
}

// Updates any build files that contain a version tag
def updateFiles(String newTag) {
    debug("updateFiles( newTag: ${newTag} )")

    // TODO - Implement for updating a file
    debug("updateFiles: TODO Implement")
}

// Tags the repo
def tagRepo(String newTag) {
    debug("tagRepo( newTag: ${newTag} )")
    
    def tagStatus = sh(script: "git tag ${newTag}", returnStatus: true)
    if( tagStatus != 0) {
        throw new Exception("Unable to tag the repository with tag '${newTag}'")
    }

    def pushStatus = sh(
        script: "${GIT_SSH_COMMAND} git push origin ${newTag}", 
        returnStatus: true)
    if( pushStatus != 0) {
        throw new Exception("Unable to push the tag '${newTag}'")
    }
}
node ('tpt2-slave'){
   
       stage("Increment Tag") {
        try {
            def prEvent = getPullRequestEvent()
            debug("Increment Tag: prEvent: ${prEvent}")
            
            def labels = getLabels(prEvent)
            debug("Increment Tag: labels: ${labels}")
            
            VersionIncrement increment = getVersionIncrement(labels)
            debug("Increment Tag: increment: ${increment}")
            if(increment != null ) {
                def tags = getTags()
                debug("Increment Tag: tags: ${tags}")

                def newTag = getNewTag(tags, increment)
                debug("Increment Tag: newTag: ${newTag}")

                updateFiles(newTag)
                tagRepo(newTag)
            }
        }
        catch(Exception ex) {
            error "[ERROR] ${ex}"
        }
    }

   def serverArti = Artifactory.server 'CWDS_DEV'
   def rtGradle = Artifactory.newGradleBuild()
   properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')), disableConcurrentBuilds(), [$class: 'RebuildSettings', autoRebuild: false, rebuildDisabled: false],
   parameters([
      string(defaultValue: 'latest', description: '', name: 'APP_VERSION'),
      string(defaultValue: 'master', description: '', name: 'branch'),
      booleanParam(defaultValue: false, description: 'Default release version template is: <majorVersion>_<buildNumber>-RC', name: 'RELEASE_PROJECT'),
      string(description: 'Fill this field if need to specify custom version ', name: 'OVERRIDE_VERSION'),
      booleanParam(defaultValue: true, description: '', name: 'USE_NEWRELIC'),
      string(defaultValue: 'inventories/tpt2dev/hosts.yml', description: '', name: 'inventory')
      ]), pipelineTriggers([pollSCM('H/5 * * * *')])])
  try {
   stage('Preparation') {
		  git branch: '$branch', url: 'https://github.com/ca-cwds/geo-services-api.git'
		  rtGradle.tool = "Gradle_35"
		  rtGradle.resolver repo:'repo', server: serverArti
		  rtGradle.useWrapper = true
	          OVERRIDE_VERSION = $newTag
   }
   stage('Build'){
		def buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'readArguments jar -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
   }
   stage('Unit Tests') {
       buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'test jacocoTestReport', switches: '--stacktrace'
	   publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'JUnitReports', reportTitles: 'JUnit tests summary'])

   }
   stage('SonarQube analysis'){
		withSonarQubeEnv('Core-SonarQube') {
			buildInfo = rtGradle.run buildFile: 'build.gradle', switches: '--info', tasks: 'sonarqube'
        }
    }

	stage ('Push to artifactory'){
	    rtGradle.deployer.deployArtifacts = true
	    buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'publish -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
  		rtGradle.deployer.deployArtifacts = false
	}
	stage ('Build Docker'){
	   buildInfo = rtGradle.run buildFile: 'build.gradle', tasks: 'createDockerImage -DRelease=$RELEASE_PROJECT -DBuildNumber=$BUILD_NUMBER -DCustomVersion=$OVERRIDE_VERSION'
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
  
 } catch (e)   {
       emailext attachLog: true, body: "Failed: ${e}", recipientProviders: [[$class: 'DevelopersRecipientProvider']],
       subject: "GEO Services API CI pipeline failed", to: "Leonid.Marushevskiy@osi.ca.gov, Alex.Kuznetsov@osi.ca.gov, Oleg.Korniichuk@osi.ca.gov, alexander.serbin@engagepoint.com, vladimir.petrusha@engagepoint.com"
       slackSend channel: "#geo-services-api", baseUrl: 'https://hooks.slack.com/services/', tokenCredentialId: 'slackmessagetpt2', message: "GEO Services API pipeline failed: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
	   publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/integrationTest', reportFiles: 'index.html', reportName: 'Integration Tests Reports', reportTitles: 'Integration tests summary'])
	   publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'build/reports/tests/test', reportFiles: 'index.html', reportName: 'JUnitReports', reportTitles: 'JUnit tests summary'])
       cleanWs()
	   }
}

