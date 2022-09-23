# Deploy a Spring Web App inside a container

## Prerequisites
1. Install [Docker](https://docs.docker.com/desktop/install/mac-install/) 
2. Install [Docker Compose](https://docs.docker.com/compose/install/)  
3. Create an account on [Docker Hub](https://hub.docker.com/signup)
4. Login on Docker Desktop to your Docker Hub account

## Activity

### Setup
I have included a very simple web app in the directory that launches a web server on port 8080 and displays a hello 
world message.  
You can launch this server by performing following:
- `./mvnw package && java -jar target/containerDemo-0.0.1-SNAPSHOT.jar`  
- Then go to localhost:8080 to see your “Hello Docker World” message.

### Containerise It
Docker has a simple "Dockerfile" file format that it uses to specify the “layers” of an image.  
Create the following Dockerfile in your Spring Boot project:

```
FROM openjdk:19-jdk
ARG JAR_FILE=target/containerDemo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

### What does this mean?
**FROM** - This instruction sets the Base Image for subsequent instructions. As such, a valid Dockerfile must start with 
a FROM instruction. The image can be any valid image – it is especially easy to start by pulling an image from the 
Public Repositories.  

**ARG** - The ARG instruction defines a variable that users can pass at build-time to the builder with the docker build 
command using the --build-arg <varname>=<value> flag or it can be set in the Dockerfile like we are doing. If a user 
specifies a build argument that was not defined in the Dockerfile, the build outputs a warning. A Dockerfile may include 
one or more ARG instructions.   

**COPY** - The COPY instruction copies new files or directories from <src> and adds them to the filesystem of the 
container at the path <dest>. Multiple <src> resources may be specified but the paths of files and directories will be 
interpreted as relative to the source of the context of the build.

**ENTRYPOINT** - An ENTRYPOINT allows you to configure a container that will run as an executable. Once the container is 
created this is the command that will run.

You can build the image from the Dockerfile with the following command:

### Building the image
`docker build -t {docker_hub_username}/demo-app .`

This command builds an image and tags it as `{docker_hub_username}/demo-app`. The fullstop at the end is just specifying 
the directory where the Dockerfile is located relative to where the command has been run. In our case we use the full 
stop to represent the current directory.  

This Dockerfile is very simple, but it is all you need to run a Spring Boot app with no frills: just Java and a JAR 
file. The build creates a spring user and a spring group to run the application. It is then copied (by the COPY command) 
the project JAR file into the container as app.jar, which is run in the ENTRYPOINT. The array form of the Dockerfile 
ENTRYPOINT is used so that there is no shell wrapping the Java process.  

### Running the container
You can then run the container using:
`docker run -p 8080:8080 {docker_hub_username}/demo-app`

Congratulations! You have created a Docker container for a Spring Boot application! By default, Spring Boot applications run on port 8080 inside the container, and we mapped that to the same port on the host by using -p on the command line.

### Pushing to Container Repository (Docker Hub)
Login to docker hub and [create](https://hub.docker.com/repository/create) a public repository call `demo-app`

IMAGE

Create a tag of the current latest image. using Semantic Versioning.

```shell
docker tag {docker_hub_username}/demo-app:latest {docker_hub_username}/demo-app:v1.0.0

```

Push the latest and the tagged builds to Container Repository (Docker Hub). We push both the latest and the tag to enable
us to pull down either the latest build or a specific tag when we want to use it.

```shell
docker push {docker_hub_username}/demo-app:latest
docker push {docker_hub_username}/demo-app:v1.0.0
```

Checkout the containers on in you Repository: https://hub.docker.com/repository/docker/{docker_hub_username}/demo-app

