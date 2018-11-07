import jenkins.model.*
import hudson.security.*
import com.cloudbees.plugins.credentials.*

Jenkins jenkins = Jenkins.getInstance()
def strategy = new hudson.security.GlobalMatrixAuthorizationStrategy()

def admin_group = "adhocteam*infrastructure"

//Overall - http://javadoc.jenkins-ci.org/jenkins/model/Jenkins.html
strategy.add(Jenkins.ADMINISTER, admin_group)
strategy.add(Jenkins.RUN_SCRIPTS, admin_group)
strategy.add(Jenkins.READ, admin_group)

// Agent (Slave < 2.0) - http://javadoc.jenkins-ci.org/jenkins/model/Jenkins.MasterComputer.html
strategy.add(Jenkins.MasterComputer.BUILD, admin_group)
strategy.add(Jenkins.MasterComputer.CONFIGURE, admin_group)
strategy.add(Jenkins.MasterComputer.CONNECT, admin_group)
strategy.add(Jenkins.MasterComputer.CREATE, admin_group)
strategy.add(Jenkins.MasterComputer.DELETE, admin_group)
strategy.add(Jenkins.MasterComputer.DISCONNECT, admin_group)

// Job - http://javadoc.jenkins-ci.org/hudson/model/Item.html
strategy.add(hudson.model.Item.BUILD, admin_group)
strategy.add(hudson.model.Item.CANCEL, admin_group)
strategy.add(hudson.model.Item.CONFIGURE, admin_group)
strategy.add(hudson.model.Item.CREATE, admin_group)
strategy.add(hudson.model.Item.DELETE, admin_group)
strategy.add(hudson.model.Item.DISCOVER, admin_group)
strategy.add(hudson.model.Item.EXTENDED_READ, admin_group)
strategy.add(hudson.model.Item.READ, admin_group)
strategy.add(hudson.model.Item.WIPEOUT, admin_group)
strategy.add(hudson.model.Item.WORKSPACE, admin_group)

// Run - http://javadoc.jenkins-ci.org/hudson/model/Run.html
strategy.add(hudson.model.Run.DELETE, admin_group)
strategy.add(hudson.model.Run.UPDATE, admin_group)
strategy.add(hudson.model.Run.ARTIFACTS, admin_group)

// View - http://javadoc.jenkins-ci.org/hudson/model/View.html
strategy.add(hudson.model.View.CONFIGURE, admin_group)
strategy.add(hudson.model.View.CREATE, admin_group)
strategy.add(hudson.model.View.DELETE, admin_group)
strategy.add(hudson.model.View.READ, admin_group)

// SCM - http://javadoc.jenkins-ci.org/hudson/model/View.html
strategy.add(hudson.scm.SCM.TAG, admin_group)

// Credentials - https://github.com/jenkinsci/credentials-plugin/blob/master/src/main/java/com/cloudbees/plugins/credentials/CredentialsProvider.java
strategy.add(CredentialsProvider.CREATE, admin_group)
strategy.add(CredentialsProvider.UPDATE, admin_group)
strategy.add(CredentialsProvider.VIEW, admin_group)
strategy.add(CredentialsProvider.DELETE, admin_group)
strategy.add(CredentialsProvider.MANAGE_DOMAINS, admin_group)

// Plugin Manager http://javadoc.jenkins-ci.org/hudson/PluginManager.html
strategy.add(hudson.PluginManager.UPLOAD_PLUGINS, admin_group)
strategy.add(hudson.PluginManager.CONFIGURE_UPDATECENTER, admin_group)

// Team that has access to RUN the Job(s)
strategy.add(Jenkins.READ, 'authenticated')
strategy.add(hudson.model.Item.BUILD, 'authenticated')
strategy.add(hudson.model.Item.CANCEL, 'authenticated')
strategy.add(hudson.model.Item.DISCOVER, 'authenticated')
strategy.add(hudson.model.Item.READ, 'authenticated')

jenkins.setAuthorizationStrategy(strategy)
jenkins.save()