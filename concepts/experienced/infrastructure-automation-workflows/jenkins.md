# Jenkins

- Jenkins is a Continuous Integration tool that allows seamless, ongoing development, testing and deployment of newly created code.
- Continuous Integration is a process wherein developers commit changes to source code from a shared repository, and all the changes to the source code are built continuously. Can occur multiple times a day and each commit is continuously monitored by the CI server.
- Why Jenkins?
    - open source and free.
    - modular
    - can integrate with many DevOps tools
    - thousands of plugins
- Jenkins Applications
    - Increased code coverage
    - No broken code
    
## Jenkins Architecture

Jenkins flow:
- Developers commit changes to the source code, found in the repository.
- The Jenkins CI server checks the repository at regular intervals and pulls any newly available code.
- The Build Server builds the code into an executable file. In case the build fails, feedback is sent to the developers.
- Jenkins deploys the build application to the test server. If the test fails, the developers are alerted.
- If the code is error-free, the tested application is deployed on the production server.

The files can contain different code and be very large, requiring multiple builds. However, a single Jenkins server cannot handle multiple files and builds simultaneously; for that, a distributed Jenkins architecture is necessary.

#### Jenkins Master-Slave Architecture
![Jenkins Master-Slave Architecture](/images/jenkins-master-slave-architecture.avif)

- Jenkins slaves can be running different build versions of the code for different OSs and the Master server controls how each of the builds operates.