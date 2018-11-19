pipeline {
    agent {
        label 'general'
    }

    stages {
        stage('Build') {
            steps {
                sh 'docker build --pull -t adhocteam/jenkins:latest .'
            }
        }

    stage('Publish') {
      when {
        branch 'master'
      }
      steps {
        withDockerRegistry([ credentialsId: "dockerhub-user", url: "" ]) {
          sh 'docker push adhocteam/jenkins:latest'
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