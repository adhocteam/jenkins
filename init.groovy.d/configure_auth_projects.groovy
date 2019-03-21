import jenkins.security.QueueItemAuthenticatorConfiguration
import org.jenkinsci.plugins.authorizeproject.GlobalQueueItemAuthenticator
import org.jenkinsci.plugins.authorizeproject.strategy.SystemAuthorizationStrategy
import hudson.model.AdministrativeMonitor;



// Configure the plugin and set to run as System user
// This will happen anyway because GitHub triggered jobs run as System
GlobalQueueItemAuthenticator auth = new GlobalQueueItemAuthenticator(
    new SystemAuthorizationStrategy()
)
QueueItemAuthenticatorConfiguration.get().authenticators.add(auth)

// Suppress the warning since it doesn't like System jobs
// From reviewing the code it looks like it fires in error for us
// because it doesn't properly see that our GitHub auth strategy
// restricts who can run jobs to just trusted users
AdministrativeMonitor.all().each {
  if (it.getDisplayName() == 'Access Control for Builds') {
   it.disable(true)
  }
}