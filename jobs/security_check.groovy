pipeline {
  agent {
    label 'rails'
  }

  triggers {
    cron('0 17 * * 1-5') // 1pm EST Monday-Friday
  }

  environment {
    DEPLOY_APP_NAME = 'the_people_app'
    DEPLOY_REGION = 'us-east-1'
    DOCKER_FLAGS = ' '
    EB_PLATFORM = 'ruby-2.5-(puma)'
    ECR_URL = '968246069280.dkr.ecr.us-east-1.amazonaws.com/people-app'
  }

  stages {
    stage('Audit bundled gems') {
      steps {
        sh '''#!/bin/bash
          set -e
          docker build -f jenkins/test/Dockerfile -t adhoc_co .
          audit=$(docker run adhoc_co bundle audit -uq || true)
          if [[ -z $audit ]]; then
              exit 0
          fi
          curl -X POST -H 'Content-type: application/json' --data '{"attachments": [ { "fallback": "'"$audit"'", "color": "#ff0000", "pretext": ":siren: Vulnerable gems found:", "title": "The People App", "title_link": "https://github.com/adhocteam/adhoc_co", "text": "'"$audit"'" }]}' $SLACK_URL
        '''
      }
    }
  }
  post {
    cleanup {
      cleanWs()
    }
  }
}
