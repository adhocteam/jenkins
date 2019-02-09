pipeline {
    agent {
        label 'general'
    }

    environment {
        TAG = 'latest'
    }

    stages {
        state('Set Tag') {
            when {
                not { branch 'master' }
            }

            steps {
                script {
                    TAG = "${BRANCH_NAME}"
                }
            }
        }

        stage('Build') {
            steps {
                sh "docker build --pull --no-cache -t adhocteam/jenkins:${TAG} ."
            }
        }

        stage('Publish') {
            when {
                branch 'master'
            }
            steps {
                withDockerRegistry([ credentialsId: 'dockerhub-user', url: "" ]) {
                sh "docker push adhocteam/jenkins:${TAG}"
                }
            }
        }
    }
    post {
        always {
            deleteDir()
            cleanWs()
        }
    }
}