multibranchPipelineJob("demo") {
    displayName "Demo"
    description "https://github.com/adhocteam/"

    branchSources {
        github {
            scanCredentialsId('github-user')
            repoOwner('adhocteam')
            repository('sample-task-toolkit')
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
        traits << 'org.jenkinsci.plugins.github__branch__source.TagDiscoveryTrait' {}

        // Build strategies not available on Org Folders so doing it here
        def buildStrategies = it / buildStrategies
        buildStrategies << 'jenkins.branch.buildstrategies.basic.BranchBuildStrategyImpl' {}
        buildStrategies << 'jenkins.branch.buildstrategies.basic.ChangeRequestBuildStrategyImpl' {
            ignoreTargetOnlyChanges false
        }
        buildStrategies << 'jenkins.branch.buildstrategies.basic.TagBuildStrategyImpl' {
            atLeastMillis '-1'
            atMostMillis '86400000'
        }
    }

    // As a back-up look for new branches/PRs once per day if no pushes
    configure { node ->
        node / triggers / 'com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger' {
        spec('H H * * *')
        interval(86400000)
        }
    }

}