# Contributing to an Ad Hoc Infrastructure Team Repo

:tada: Thank you for being willing to contribute! :tada:

The following is a set of guidelines for contributing to repositories managed [Ad Hoc's](https://adhoc.team) [Infrastructure Team](https://github.com/adhocteam/infrastructure):lock: on GitHub. These are guidelines, not rules. Use your best judgment if your case falls outside of this guidance.

We have marked with :lock: any private, internal links only available to Ad Hoc team members.

#### Table Of Contents

[Code of Conduct](#code-of-conduct)

[Creating Issues](#creating-issues)

- [Reporting Bugs](#reporting-bugs)
- [Suggesting Enhancements](#suggesting-enhancements)
- [Architecture Changes](#architecture-changes)

[Pull Requests](#pull-requests)

[Issue and Pull Request Labels](#issue-and-pull-request-labels)

## Code of Conduct

This project and everyone participating in it is expected to treat each other reasonably, respectfully, and professionally. Ad Hoc employees are subject to [company policy](https://github.com/adhocteam/handbook/blob/master/policies/admin-policies.md#31-eeo-statement-and-non-harassment-policy):lock:. Please report unacceptable behavior to [infrastructure.admin@adhoc.team](mailto:infrastructure.admin@adhoc.team).

## Creating Issues

If your problem is support related (e.g., an account lockout or data update), please use the [support channels](SUPPORT.md) instead of using issues. We try to restrict the issues to things requiring a code change.

### Reporting Bugs

This section guides you through submitting a bug report for one of our repositories. Following these guidelines helps us to understand the bug, reproduce the behavior, and find related issues.

Before creating bug reports, please check [for existing bug reports](#search-for-existing-bug-report) as you might find out that you don't need to create one. When you are creating a bug report, please [include as many details as possible](#how-do-i-submit-a-good-bug-report). Fill out [the required template](ISSUE_TEMPLATE/BUG_TEMPLATE.md); the information it asks for helps us resolve issues faster.

#### Search for existing bug report

**Perform a [cursory search](https://github.com/search?q=+is%3Aissue+org%3Aadhocteam)** to see if the problem has already been reported.

- If it has **and the issue is still open**, add a comment to the existing issue instead of opening a new one.

- If you find a **Closed** issue that seems like it is the same thing that you're experiencing, open a new issue and include a link to the original issue in the _Related Issues_ section of your new one.

#### How Do I Submit A (Good) Bug Report?

Bugs are tracked as [GitHub issues](https://guides.github.com/features/issues/). Create an issue on the relevant repository and provide the following information by filling in the appropriate template.

Explain the problem and include additional details to help maintainers reproduce the problem:

- **Use a clear and descriptive title** for the issue to identify the problem.
- **Describe the exact steps which reproduce the problem** in as many details as possible. This is critical for us to be able to reproduce the issue.
- **Describe the behavior you observed after following the steps** and point out what exactly is the problem with that behavior.
- **Explain which behavior you expected to see instead and why.**
- **Include screenshots and animated GIFs** which show you following the described steps and clearly demonstrate the problem.
- **If the problem wasn't triggered by a specific action**, describe what you were doing before the problem happened and share more information using the guidelines below.

- **Can you reliably reproduce the issue?** If not, provide details about how often the problem happens and under which conditions it normally happens.

Include details about your configuration and environment:

- **What's the name and version of the OS you're using**? On MacOs and Linux, `uname -a` will output the information.
- **What's the name and version of the browser you're using**? If you tested with multiple browsers, please indicate which were or were not affected by the issue.
- **For non-website issues, which software and what versions you have installed?** For example, if a Python script is part of the issue, include the output of `python --version`.

### Suggesting Enhancements

This section guides you through submitting an enhancement suggestion, including completely new features and minor improvements to existing functionality.

Before creating enhancement suggestions, **please perform a [cursory search](https://github.com/search?q=+is%3Aissue+org%3Aadhocteam)** to see if the idea has already been reported and, if so, add your input to the existing issue.

#### How Do I Submit A (Good) Enhancement Suggestion?

- **Use a clear and descriptive title** for the issue to identify the suggestion.
- **Explain why this enhancement would be useful** to you and others. This helps us evaluate the potential value of it during triage and prioritization.
- **Provide a step-by-step description of the suggested enhancement** in as many details as possible if it involves alternating a user flow or involves some user interactions.
- **Include annotated screenshots and animated GIFs** which help you demonstrate the steps or point out the part of the site your suggesting changing. A quick and dirty "mock-up" in this way is invaluable for understanding the suggestion.
- **Write clear acceptance criteria** that are objective and narrow in scope. "Looks good" is a poor acceptance criteria. "All items aligned on the left margin" and "All text styled in light grey Proxima Nova" are good criteria.

### Architecture Changes

If your suggestion extends beyond a bug or single feature, we treat that as architecture change even if the proposal is just to add a major new function. This is because any large change will necessitate some amount of refactoring and rethinking of the architecture. Therefore, we ask for a more rigorous starting point and lengthier discussion on the proposal.

Be sure to select the [Architecture Change](ISSUE_TEMPLATE/ARCHITECTURE.md) template, which includes all the information required.

#### How Do I Submit A (Good) Architecture Change?

- **Use a clear and descriptive title** for the issue to identify the suggestion.
- **Provide thoughtful responses to all sections of the template** because the change will be a significant investment of our team's time, we ask that you demonstrate the value of the change by committing your own time to thinking it through.
- **Include annotated screenshots, diagrams or charts** which help you demonstrate the steps or clarify the new architecture.
- **Consider a smaller scoped enhancement(s) instead** that may capture most of the value with lesser cost. If you can go that route, it is generally preferable.

## Pull Requests

The process described here has several goals:

- Maintain our software quality
- Enable a sustainable system for us to review contributions

Please follow these steps to have your contribution considered by the maintainers:

1. If your PR does not respond to an open Issue, please create one first to allow a chance to discuss the change prior to implementation.
2. Name your branch using the pattern: `yourname/PR/short-summary` for example `bob/11/update-docs`.
3. GitHub will open our default template. If you're submitting a [bug fix](PULL_REQUEST_TEMPLATE/BUG.md) or [documentation change](PULL_REQUEST_TEMPLATE/DOCUMENTATION.md), then you can use those alternative templates instead.
4. After you submit your pull request, verify that all [status checks](https://help.github.com/articles/about-status-checks/) are passing <details><summary>What if the status checks are failing?</summary>If a status check is failing, and you believe that the failure is unrelated to your change, please leave a comment on the pull request explaining why you believe the failure is unrelated. A maintainer will re-run the status check for you. If we conclude that the failure was a false positive, then we will open an issue to track that problem with our status check suite.</details>
5. Add the `ready for review 👀` label to signal you believe your PR is merge-able. GitHub will automatically add the appropriate reviewers when your PR is opened, so the label signals when something is truly ready for a maintainer's attention.

While the prerequisites above must be satisfied prior to having your pull request reviewed, the reviewer(s) may ask you to complete additional design work, tests, or other changes before your pull request can be ultimately accepted.

After approval:

1. Use the `Squash and Merge` function to merge the PR. We use this to keep the git history comprehensible.
2. Delete the branch in GitHub.

After merge, either our Continuous Deployment infrastructure or the team will take care of deploying it to production.

## Issue and Pull Request Labels

This section lists the labels we use to help us track and manage issues and pull requests. [GitHub search](https://help.github.com/articles/searching-issues/) makes it easy to use labels for finding groups of issues or pull requests you're interested in.

### Type of Issue and Issue State

| Label name       | Description                                                                         |
| ---------------- | ----------------------------------------------------------------------------------- |
| `bug`            | Confirmed bugs or reports that are very likely to be bugs                           |
| `enhancement`    | A single, discrete feature addition to the application                              |
| `architecture`   | A major, multi-part change requiring a significant addition or refactor of the code |
| `blocked`        | Issues blocked on other issues or external dependencies                             |
| `interesting 🤔` | Good issues for a teammate to pick up if they don't work on a repo day to day       |


### Pull Request Labels

| Label name            | Description                                                        |
| --------------------- | ------------------------------------------------------------------ |
| `ready for review 👀` | Pull requests which need code review and approval from maintainers |
