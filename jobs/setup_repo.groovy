multibranchPipelineJob("demo") {
    displayName "Demo"
    description "https://github.com/adhocteam/"

    branchSources {
        branchSource {
            source {
                github {
                    credentialsId 'github-user'
                    repoOwner 'adhollc'
                    repository ''
                    repositoryUrl 'https://github.com/adhocllc/repo-name'
                    configuredByUrl true
                }
            }
            buildStrategies {
                skipInitialBuildOnFirstBranchIndexing()
                buildRegularBranches()
                buildChangeRequests {
                    ignoreTargetOnlyChanges(false)
                    ignoreUntrustedChanges(true)
                }
                buildTags {
                    atLeastDays ''
                    atMostDays '7'
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
