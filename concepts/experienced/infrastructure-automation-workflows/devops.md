## What is DevOps?
- A software engineering approach that unifies Development and Operations team under an umbrella of tools to automate every stage.
- DevOps helps achievers meet certain milestones:
    - Frequent Release of Deliverables
    - Team Collaboration
    - Build Management of Unplanned Work
    - Faster Resolution of Issues

## What is a CI/CD pipeline?
- A pipeline is a concept that introduces a series of events or tasks that are connected in a sequence to make quick software releases. For example, there is a task, that task has got five different stages, and each stage has got several steps. All the steps in phase one must be completed, to mark the latter stage to be complete.
![Pipeline with Jenkins](/images/CI_CD_pipeline_with_Jenkins.avif)

- CI/CD pipeline is responsible for building code, running tests and deploying new software versions.
![CI/CD pipeline](/images/Continuous_Integration.avif)

What is Continuous Integration?
- CI is a practice that integrates code into a shared repository. Uses automated verifications for early detection of problems. 

What is Continuous Delivery?
- CD is a practice where code changes are automatically prepared for release into production.

## Best practices for CI/CD Pipeline Security
- Employ one-time passwords for your more sensitive systems and tools
- Use password managers and rotate your passwords after every use
- Take out all hardcoded secrets from CI/CD config files and Jenkins files
- Make sure secrets aren’t accidentally passed along during builds for pull requests occurring in CI/CD pipeline
- Follow the practice of least privilege. This means giving access only to the requisite secrets, nothing beyond that. This practice applies to applications, employee access, systems, and connected devices that require permissions or privileges to perform certain tasks.
- Use authentication measures to confirm machine identity
- Keep track of who has access to what resources. Create a clear repository of access management, regardless of whether it’s task-based, time-based, or role-based.
- Distribute secrets among Jenkinsfiles to reduce the risk of attacks on the files
- Scan scripted builds and regularly monitor source code for vulnerabilities before deploying an app into production