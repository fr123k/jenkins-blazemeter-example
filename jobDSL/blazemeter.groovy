pipelineJob("blazemeter/blazemeter_example_1") {
    parameters {
        gitParam('revision') {
            type('BRANCH_TAG')
            sortMode('ASCENDING_SMART')
            defaultValue('origin/master')
        }
    }

    triggers {
        githubPush()
    }

    logRotator {
        numToKeep(10)
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github("fr123k/jenkins-blazemeter-example", "ssh")
                        credentials("deploy-key-shared-library")
                    }

                    branch('$revision')
                }
            }
            scriptPath('jenkins/Jenkinsfile')
        }
    }
}
