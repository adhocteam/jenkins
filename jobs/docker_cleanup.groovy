job('docker-cleanup') {
    displayName('Docker clean-up')
    description('Cleans up all left-over docker item to prevent the hard-drive filling up')

    triggers {
        cron('H H * * *')
    }

    parameters {
        labelParam('Workers') {
            defaultValue('worker')
            description('Select nodes')
            allNodes('allCases', 'IgnoreOfflineNodeEligibility')
        }
    }

    steps {
        shell( '''
        set -xe

        docker system df -v

        docker system prune -af --volumes --filter "until=24h"

        docker system df -v
        df -h
        ''')
    }

    logRotator {
        daysToKeep(7)
    }
}


