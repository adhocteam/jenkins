multibranchPipelineJob("demo") {
    displayName "VA Appeals Demo"
    description "https://github.com/adhocteam/va-appeals-itd"

    branchSources {
        branchSource {
          source {
            github {
                credentialsId 'github-user'
                repoOwner 'adhocteam'
                repository 'va-appeals-itd'
            }
          }
          buildStrategies {
            buildRegularBranches()
            buildChangeRequests {
                ignoreTargetOnlyChanges(false)
                ignoreUntrustedChanges(true)
            }
            buildTags {
                atLeastDays ''
                atMostDays '1'
            }
          }
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
    }

    // As a back-up look for new branches/PRs once per day if no pushes
    configure { node ->
        node / triggers / 'com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger' {
        spec('H H * * *')
        interval(86400000)
        }
    }

}