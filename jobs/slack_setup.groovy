import jenkins.model.Jenkins
import net.sf.json.JSONObject

// parameters
def slackParameters = [
  slackBaseUrl:             'https://adhoc.slack.com/services/hooks/jenkins-ci/',
  slackBotUser:             'true',
  slackBuildServerUrl:      'https://jenkins.adhoc.team:443/',
  slackRoom:                '#inf-alerts',
  slackSendAs:              'Jenkins',
  slackTeamDomain:          'adhoc',
  slackToken:               '',
  slackTokenCredentialId:   'slack-token'
]

// get Jenkins instance
Jenkins jenkins = Jenkins.getInstance()

// get Slack plugin
def slack = jenkins.getExtensionList(jenkins.plugins.slack.SlackNotifier.DescriptorImpl.class)[0]

// define form and request
JSONObject formData = ['slack': ['tokenCredentialId': 'slack-token']] as JSONObject
def request = [getParameter: { name -> slackParameters[name] }] as org.kohsuke.stapler.StaplerRequest

// add Slack configuration to Jenkins
slack.configure(request, formData)

// save to disk
slack.save()
jenkins.save()