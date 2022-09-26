# Kubernetes Lab

## Prerequisite

1. Install [Docker](https://docs.docker.com/get-docker/)
2. Install [kubectl](https://kubernetes.io/docs/tasks/tools/#kubectl) the Kubernetes Commandline tool
3. Install [Minikube](https://minikube.sigs.k8s.io/docs/start/) to allow use to create a cluster locally.

## Activity

### Start Minikube

This will spin up Minikube (A small local kubernetes cluster) within a Docker container so you can deploy Pods into it.

```shell
minikube start
```

Load the Kubernete dashboard. This command will start the dashboard and open it in your browser.

```shell
minikube dashboard
```

Once the dashboard has loaded check on the Pods page. There should not be any pods running yet.

### Create a Deployment

You will need to open a new terminal tab/window as the dashboard will be running in the current one.

The following command will get the Docker container we created during the 
[container lab](../Containerisation/containerDemo/README.md) and deploy it to the Minikube Kubernetes cluster

```shell
kubectl create deployment demo-node --image={docker_hub_username}/demo-app:v1.0.0
```

#### Check the deployment

Check the Deployment page on the dashboard. You should now see a Deployment listed for the demo-app. 

![The deployments page of the Kubernetes dashboard](docs/deployments.png)

You can also check the deployments using the kubectl

```shell
kubectl get deployments
```

The output should look like this:

```
NAME        READY   UP-TO-DATE   AVAILABLE   AGE
demo-node   1/1     1            1           2m55s
```

#### Check Pods

Check the Pods page on the dashboard. You should now see a Pod listed for the demo-app. Not it may to be running 
straight away you may have to wait a minute

![The Pods page of the Kubernete dashboard](docs/pods.png)

You can also check the running Pods using the kubectl

```shell
kubectl get pods
```

The output should look like this:

```
NAME                         READY   STATUS    RESTARTS   AGE
demo-node-6b584b4f6c-nfjsp   1/1     Running   0          7m22s
```

### Accessing The App

At the moment the app is only accessible by in IP within the Kubernente cluster. We want the app to be available to the 
outside world. To do this we need to expose the Pod as a Kubernetes Service. We can do this with the following command

```shell
kubectl expose deployment demo-node --type=LoadBalancer --port=8080
```

The `--type=LoadBalancer` flag indicates that you want to expose your Service outside the cluster.

#### check Service

The service should not be listed on the services page of the dashboard

![The Services page of the Kubernetes dashboard](docs/services.png)

You can also get a list of the Service using the following kubectl command

```shell
kubectl get services
```

The output should look like the following:

```
NAME         TYPE           CLUSTER-IP     EXTERNAL-IP   PORT(S)          AGE
demo-node    LoadBalancer   10.101.96.95   <pending>     8080:31647/TCP   4m48s
kubernetes   ClusterIP      10.96.0.1      <none>        443/TCP          134m
```

On cloud providers that support load balancers, an external IP address would be provisioned to access the Service. On 
minikube, the LoadBalancer type makes the Service accessible through the minikube service command.

```shell
minikube service demo-node
```

This command will load the app in the web browser, and you should see `Hello Docker World`.

### Scaling

```shell
kubectl scale demo-node --replicas=3
```

Check the Pods page on the dashboard. You should now see 3 Pods listed for the demo-app. 

![The Pods page of the Kubernete dashboard](docs/three-pods.png)

You can also check the running Pods using the kubectl

```shell
kubectl get pods
```

The output should look like this:

```
NAME                         READY   STATUS    RESTARTS   AGE
demo-node-6b584b4f6c-hptqw   1/1     Running   0          2m45s
demo-node-6b584b4f6c-kx5jp   1/1     Running   0          2m45s
demo-node-6b584b4f6c-zn9x7   1/1     Running   0          5m54s
```

The deployment should now be aware of the three pods and routing traffic to all of them. Check the Deployments page on 
the dashboard. You should now see 3 Pods listed for the demo-node.

![The Pods page of the Kubernete dashboard](docs/three-pods.png)

you can also check this via kubectl, using the following command:

```shell
kubectl get deployments
```

The output should look like this:

```
NAME        READY   UP-TO-DATE   AVAILABLE   AGE
demo-node   3/3     3            3           14m
```


### Clean up

Now you can clean up the resources you created in your cluster:

```shell
kubectl delete service demo-node
kubectl delete deployment demo-node
```

### Apply

`deployment/demo-node.yml`

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: demo-node
spec:
  replicas: 1
  selector:
    matchLabels:
      app: "demo-node"
  template:
    metadata:
      labels:
        app: demo-node
        track: stable
        version: 1.0.0
    spec:
      containers:
        - name: demo-node
          image: "braddle/demo-app:1.0.0"
          ports:
            - containerPort: 8080
```

```shell
kubectl apply -f deployments/demo-node.yml
```

Expected output `deployment.apps/demo-node created`

Re-running the apply command at this point should not change anything in the cluster. Expected output 
`deployment.apps/demo-node unchanged`

Update the number of replicas to 3 and re-run the apply command. Expected output `deployment.apps/demo-node configured`

`services/demo-node.yml`

```yaml
apiVersion: v1
kind: Service
metadata:
  name: "demo"
spec:
  selector:
    app: "demo-node"
  ports:
    - port: 8080
      targetPort: 8080
      protocol: "TCP"
```

```shell
kubectl apply -f services/demo-node.yml
```


### Clean up

Now you can clean up the resources you created in your cluster:

```shell
kubectl delete service demo-node
kubectl delete deployment demo-node
```

Optionally, stop the Minikube virtual machine (VM):

```shell
minikube stop
```

Optionally, delete the Minikube VM:

```shell
minikube delete
```