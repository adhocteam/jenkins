multibranchPipelineJob("va-demo") {
    displayName "VA Demo"
    description "https://github.com/adhocteam/va-demo"

    branchSources {
        github {
            scanCredentialsId('github-user')
            repoOwner('adhocteam')
            repository('sample-task-toolkit')
        }
    }
    triggers {
        githubPush()
    }
}