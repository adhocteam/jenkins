multibranchPipelineJob("va-demo") {
    displayName "MPSM Preview"
    description "https://github.com/adhocteam/mpsm-preview"

    branchSources {
        github {
            scanCredentialsId('github-user')
            repoOwner('adhocteam')
            repository('mpsm-preview')
        }
    }

    // As a back-up look for new branches/PRs once per day if no pushes
    configure { node ->
        node / triggers / 'com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger' {
        spec('H H * * *')
        interval(86400000)
        }
    }

    // Find all branches and any PRs in the "merged with target" state
    configure {
        def traits = it / sources / data / 'jenkins.branch.BranchSource' / source / traits
        traits << 'jenkins.plugins.git.traits.BranchDiscoveryTrait' {}

        traits << 'org.jenkinsci.plugins.github__branch__source.BranchDiscoveryTrait' {
            strategyId(3)
        }
        traits << 'org.jenkinsci.plugins.github__branch__source.OriginPullRequestDiscoveryTrait' {
            strategyId(1)
        }
    }
}