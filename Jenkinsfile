pipeline {
    agent {
        label 'general'
    }

    environment {
        TAG = 'latest'
    }

    stages {
        stage('Set Tag') {
            when {
                not { branch 'master' }
            }

            steps {
                script {
                    TAG=BRANCH_NAME.split('/').last()
                }
            }
        }

        stage('Build') {
            steps {
                sh "docker build --pull --no-cache -t adhocteam/jenkins:${TAG} ."
            }
        }

        stage('Publish') {
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