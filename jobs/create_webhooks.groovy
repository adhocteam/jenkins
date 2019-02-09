import jenkins.model.Jenkins
import jenkins.branch.MultiBranchProject
import jenkins.branch.OrganizationFolder

jobs = Jenkins.instance.getAllItems()
jobs.each { j ->

    if (j instanceof jenkins.branch.MultiBranchProject) {
        println('j.fullName: ' + j.fullName)
      	for (scm in j.getSCMSources()) {
            println('scm: ' + scm.getRepository())
            scm.afterSave()
        }
    }

    if (j instanceof jenkins.branch.OrganizationFolder) {
        println('j.fullName: ' + j.fullName)
        for (navigator in j.navigators) {
            println('navigator: ' + navigator)
            navigator.afterSave(j)
        }
    }
}