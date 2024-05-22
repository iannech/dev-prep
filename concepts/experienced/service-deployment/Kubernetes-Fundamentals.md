# Kubernetes
- Kubernetes is a platform for managing containerized workloads and services. 
- It provides a framework to run distributed systems resiliently by taking care of scaling, failover, providing deployment patterns etc.
- A Kubernetes cluster consists of a set of worker machines, called **Nodes**, that run containerized applications. Every cluster has atleast 1 worker node.
- The Worker Node host the **Pods**(smallest deployable unit you can create and manage in Kubernetes. It represents a set of running Containers)
- The **Control plane** manages the worker nodes and pods in the cluster.
- Kubernetes provides you with:
    - **Service discovery and load balancing** - K8s can expose a container using the DNS name or using their own IP address while also handling traffic/load distribution.
    - **Self-healing** - It restarts containers that fail, replaces containers, kills containers that don't respond to your user-defined health check and doesn't advertise them to clients until they are ready to serve.
    - **Secret and Configuration management** - Lets you store and manage sensitive information, such as passwords, Oauth tokens, and SSH keys which you can deploy and update without rebuilding your container images and without exposing secrets in your stack configuration.
    - **Horizontal scaling** - Allows up/down scaling of app with a simple command, UI or automatically based on CPU usage.
    - **Automatic rollouts and rollbacks** - You can describe the desired state for your deployed containers, and it can change the actual state to the desired state at a controlled rate.
    - **Designed for extensibility** - You can add features to your Kubernetes cluster without changing the upstream source code.
    - **IPv4/IPv6 dual-stack** - Allocation of IPv4 and IPv6 addresses to Pods and Services.

## Kubernetes Components
![Kubernetes Components](/images/components-of-kubernetes.svg)

### Control Plane Components

**kube-apiserver** 
- Component of the control plane that exposes the Kubernetes API
- It's the frontend of the control plane
- Kube-apiserver = implementation of Kubernetes API Server.
- It is designed to scale horizontally i.e you can run several instances of kube-api server and balance traffice between them.

**etcd**
- Consistent and *highly-available* *key-value store* used as Kubernetes’ backing store  for all cluster data
- Always have a back up plan for the data when using etcd

**kube-scheduler**
- Control plane component that *watches* for *newly created* pods with no assigned node and selects a node for them to run on.

**kube-controller-manager**
- Control plane component that runs Controller processes. 
- Logically, each controller is a separate process, but to reduce complexity, they are all compiled into a single binary and run in a single process.
- Examples of Controllers:
    - *Node controller*: Responsible for noticing and responding when nodes go down.
    - *Job controller*: Watches for Job objects that represent one-off taks, then creates Pods to run those tasks to completion.
    - *EndpointSlice controller*: Populates EndpointSlice objects (to provide a link between Services and Pods).
    - *ServiceAccount controller*: Creates default ServiceAccounts for new namespaces.

**cloud-controller-manager**
- Component that embeds cloud-specific control logic. It lets you link your cluster into your cloud Provider's API, and separates out the components that interact with that cloud platform from components that only interact with your cluster.
- Your cluster WONT have cloud-controller-manager if running on-prem or on local dev machine.

### Node Components

**kubelet**
- An agent that runs on each Node in the cluster. Makes sure that the containers are running in a Pod.

**kube-proxy**
- Is a network proxy that runs on each node in the cluster, implementing part of the Kubernetes Service concept.
- Maintains network rules on nodes which allow network communication to your Pods from network sessions inside or outside your cluster.
- Uses OS packet filtering layer if there's one and it's available. Otherwise kube-proxy forwards the traffic itself.

**Container runtime**
- Responsible for managing the execution and lifecycle of containers within the Kubernetes environment.

### Addons




