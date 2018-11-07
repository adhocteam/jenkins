import jenkins.model.Jenkins

// get Jenkins instance
Jenkins jenkins = Jenkins.getInstance()

// get Slack plugin
def slack = Jenkins.instance.getExtensionList('jenkins.plugins.slack.SlackNotifier$DescriptorImpl')[0]

slack.teamDomain = 'adhoc'
slack.tokenCredentialId = 'slack-token'
slack.room = '#inf-alerts'

// save to disk
slack.save()
jenkins.save()