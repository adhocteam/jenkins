organizationFolder('Adhocteam Github') {
    description("Github organization folder for github.com/adhocteam")
    displayName('Github/Adhocteam')

    // "Projects"
    organizations {
        github {
            repoOwner("adhocteam")
            apiUri("https://api.github.com")
            credentialsId('github-user')
        }
    }

    buildStrategies {
        buildRegularBranches()
        buildChangeRequests {
            ignoreTargetOnlyChanges(false)
        }
        buildTags {
            atLeastDays ''
            // only build tags which were created within the past 24 hours
            atMostDays '1'
        }
    }

    configure {
        def traits = it / navigators / 'org.jenkinsci.plugins.github__branch__source.GitHubSCMNavigator' / traits
        traits << 'org.jenkinsci.plugins.github_branch_source.BranchDiscoveryTrait' {
            strategyId 1
        }
        traits << 'org.jenkinsci.plugins.github_branch_source.ForkPullRequestDiscoveryTrait' {
            strategyId 1
            trust(class: 'org.jenkinsci.plugins.github_branch_source.ForkPullRequestDiscoveryTrait$TrustNobody')
        }
        traits << 'org.jenkinsci.plugins.github__branch__source.OriginPullRequestDiscoveryTrait' {
            strategyId 1
        }
        traits << 'org.jenkinsci.plugins.github__branch__source.TagDiscoveryTrait' {}
    }

    // "Project Recognizers"
    projectFactories {
        workflowMultiBranchProjectFactory {
            scriptPath 'Jenkinsfile'
        }
    }

    // "Orphaned Item Strategy"
    orphanedItemStrategy {
        discardOldItems {
        daysToKeep(-1)
        numToKeep(-1)
        }
    }

    // Scan Organization Folder Triggers : 1 day
    // We need to configure this stuff by hand because JobDSL only allow 'periodic(int min)' for now
    configure { node ->
        node / triggers / 'com.cloudbees.hudson.plugins.folder.computed.PeriodicFolderTrigger' {
        spec('H H * * *')
        interval(86400000)
        }
    }
}