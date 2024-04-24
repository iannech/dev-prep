# Github Actions
- This is a platform that automates Developer workflows e.g CI/CD pipeline.
- A workflow can be defined as Actions to be performed.
- Such a workflow might automate actions for events like:  issue creation -> code checkin -> pull requests -> test -> build -> deployment -> release notes -> version update etc. With GA you can configure automatic actions for such events on your repo.

## Syntax and Example
- A workflow uses a Yaml format and is defined in a file with the .yml extension.
- You must store workflow files in the **.github/workflows/** directory of your repository. Each different YAML file corresponds to a different workflow.
- Example
    ```
    name: My Workflow
    on:
    push:
        branches:
        - 'releases/*'
        - '!releases/**-alpha'
    env:
    message: 'conversation'
    my_token: ${{ secrets.GITHUB_TOKEN }}
    jobs:
    my_build:
        runs-on: ubuntu-latest
        steps:
        - name: Checking out our code
            uses: actions/checkout@master
        - name: Say something
            run: |
            echo "A little less ${message}"
            echo "A little more action"
    my_job:
        needs: my_build
        container:
        image: node:10.16-jessie
        env:
            NODE_ENV: development
        ports:
            - 80
        volumes:
            - my_docker_volume:/volume_mount
        options: --cpus 1
        services:
        redis:
            image: redis
            ports:
            - 6379/tcp
    ```
    
    **name**
    - The name of your workflow will be displayed on your repository’s actions page.

    **env**
    - A map of environment variables which can be set at different scopes. Several environment variables are available by default (GITHUB_SHA, GITHUB_REF, GITHUB_EVENT_NAME, HOME, GITHUB_EVENT_PATH…​) as well as a secret, GITHUB_TOKEN
    
    **on** Event
    - The type event that triggers the workflow

    **jobs** Collection
    - A workflow run is made up of one or more jobs identified by a unique job_id (my_build or my_job)

    Job **name**
    - The name of the job displayed on GitHub.

    **needs**
    - Identifies any job that must complete successfully before this job will run. Can be a string or array of strings

    **runs-on**
    - The type of virtual host machine to run the job on. Can be either a GitHub or self-hosted runner.
    - Jobs can also run in user specified containers

    **container**
    - Instead of running directly on a host selected with runs-on, a container can run any steps in a job that don’t already specify a container. If you have steps that use both script and container actions, the container actions will run as sibling containers on the same network with the same volume mounts. This object has the following attributes: image, env, ports, volume and options.

    **timeout-minutes**
    - The maximum number of minutes to let a workflow run before GitHub automatically cancels it. Default: 360

    **services**
    - Additional containers to host services for a job in a workflow. These are useful for creating databases or cache services. The runner on the virtual machine will automatically create a network and manage the lifecycle of the service containers. Each service is a named object in the services collection (redis or nginx for example) and can receive the same parameters than the container object.

    Job **steps**
    - A job contains a sequence of tasks called steps. Steps can run commands, run setup tasks, or run an action from your repository, a public repository, or an action published in a Docker registry. Each step runs in its own process in the virtual environment and has access to the workspace and filesystem.

    Step **name**
    - Specify the label to be displayed for this step in GitHub.

    **uses**
    - Specify an action to run as part of a step in your job. You can use an action defined in the same repository as the workflow, a public repository elsewhere on GitHub, or in a published Docker container image.
    Including the version of the action you are using by specifying a Git ref, branch, SHA, or Docker tag is strongly recommended

    **with**
    - A map of the input parameters defined by the action in its action.yml file. When the acion is container based, special parameter names are:

        - *args*, a string that defines the inputs passed to a Docker container’s *ENTRYPOINT*. It is used in place of the *CMD* instruction in a *Dockerfile*.

        - *entrypoint*, a string that defines or overrides the executable to run as the Docker container’s *ENTRYPOINT*.

    **if**
    - Prevents a step from running unless a condition is met. The value is an expression without the ${{ …​ }} block.

    **run**
    - Instead of running an existing action, a command line program can be run using the operating system’s shell. Each run keyword represents a new process and shell in the virtual environment.
    A specific shell can be selected with the *shell* attribute. Multiple commands can be run in a single shell instance using the | (pipe) operator.

    Job **strategy**
    - A build matrix strategy is a set of different configurations of the virtual environment. 

    **fail-fast**
    - When set to true (default value), GitHub cancels all in-progress jobs if any of the matrix job fails.

    **Artifact storage and caching**
    - An artifact is a file or collection of files produced during a workflow run that can be stored and shared between jobs in a workflow run. Use actions actions/upload-artifact and actions/download-artifact with parameters name and path to manipulate artifacts. Artifacts can be downloaded through the Web interface for 90 days.

    - For dependencies and other commonly reused files across runs of a given workflow, use the actions/cache action with parameters
        - **key**: The key used to save and search for a cache.
        - **path**: The file path (absolute or relative to the working directory) on the runner to cache or restore.
        - **restore-keys**: Optional - An ordered list of alternative keys to use for finding the cache if no cache hit occurred for key.

        ```
        - uses: actions/checkout@v1
        - name: Cache node modules
          uses: actions/cache@v1
          with:
          path: node_modules
          key: x-y-${{hashFiles('**/package-lock.json')}}
          restore-keys: |
            x-y-
            x-
        ```


