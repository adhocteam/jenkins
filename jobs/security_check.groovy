pipelineJob('security-check') {
  displayName('Rails Bundle Audit')
  description('Runs bundle audit on Rails repositories')

  definition {
    cpsScm {
      scm {
        github('adhocteam/jenkins')
      }
      scriptPath('jobs/Jenkinsfile.security_check')
    }
  }

  logRotator {
    daysToKeep(7)
  }
}