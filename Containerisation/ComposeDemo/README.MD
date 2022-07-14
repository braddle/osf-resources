# Docker Compose Example

You build a simple Python web application running on Docker Compose. The application uses the Flask framework and maintains a hit counter in Redis. While the sample uses Python, the concepts demonstrated here should be understandable even if you’re not familiar with it.

## Prerequisites
Make sure you have already installed both Docker Engine and Docker Compose. You don’t need to install Python or Redis, as both are provided by Docker images.  
Docker desktop: https://docs.docker.com/compose/install/  
Docker Compose: https://www.docker.com/products/docker-desktop/  

Setup
1. Create a Dockerfile - In this step, you write a Dockerfile that builds a Docker image. The image contains all the dependencies the Python application requires, including Python itself.

    In this directory, create a file named `Dockerfile` and paste the following:
    ```
    # syntax=docker/dockerfile:1
    FROM python:3.7-alpine
    WORKDIR /code
    ENV FLASK_APP=app.py
    ENV FLASK_RUN_HOST=0.0.0.0
    RUN apk add --no-cache gcc musl-dev linux-headers
    COPY requirements.txt requirements.txt
    RUN pip install -r requirements.txt
    EXPOSE 5000
    COPY . .
    CMD ["flask", "run"]
    ```
   
    ### What's this doing?
    This tells Docker to:
     - Build an image starting with the Python 3.7 image.
     - Set the working directory to /code.
     - Set environment variables used by the flask command.
     - Install gcc and other dependencies
     - Copy requirements.txt and install the Python dependencies.
     - Add metadata to the image to describe that the container is listening on port 5000
     - Copy the current directory . in the project to the workdir . in the image.
     - Set the default command for the container to flask run.


2. Define services in a Compose file - Create a file called docker-compose.yml in your project directory and paste the following:
    ```
    version: "3.9"
    services:
      web:
        build: .
        ports:
          - "8000:5000"
      redis:
        image: "redis:alpine"
    ```
    This Compose file defines two services: `web` and `redis`.
    
    **Web service**  
    The web service uses an image that’s built from the Dockerfile in the current directory. It then binds the container and the host machine to the exposed port, 8000. This example service uses the default port for the Flask web server, 5000.
    
    **Redis service**  
    The redis service uses a public Redis image pulled from the Docker Hub registry.  


3. Build and run your app with Compose - From your current directory, start up your application by running `docker compose up`.


4. Enter http://localhost:8000/ in a browser to see the application running.

    You should see a message in your browser saying:
    ![img.png](resources/img.png)
    Refresh the page.  
    The number should increment.  
    ![img_1.png](resources/img_1.png)  


5. Switch to another terminal window, and type `docker image ls` to list local images.
Listing images at this point should return `redis` and `web`.
You can inspect images with `docker inspect <tag or id>`.


6. Stop the application, either by running `docker compose down` from within your project directory in the second terminal, or by hitting CTRL+C in the original terminal where you started the app.


7. Edit the Compose file to add a bind mount - Edit docker-compose.yml in your project directory to add a bind mount for the web service:
    ```
    version: "3.9"
    services:
      web:
        build: .
        ports:
          - "8000:5000"
        volumes:
          - .:/code
        environment:
          FLASK_ENV: development
      redis:
        image: "redis:alpine"
    ```
    The new volumes key mounts the project directory (current directory) on the host to /code inside the container, allowing you to modify the code on the fly, without having to rebuild the image. The environment key sets the FLASK_ENV environment variable, which tells flask run to run in development mode and reload the code on change. This mode should only be used in development.


8. Re-build and run the app with Compose
From your current directory, type `docker compose up` to build the app with the updated Compose file, and run it.


9. Check the Hello World message in a web browser again, and refresh to see the count increment.  
    **Note** If your project is outside the Users directory (cd ~), then you need to share the drive or location of the Dockerfile and volume you are using. If you get runtime errors indicating an application file is not found, a volume mount is denied, or a service cannot start, try enabling file or drive sharing. Volume mounting requires shared drives for projects that live outside of C:\Users (Windows) or /Users (Mac), and is required for any project on Docker Desktop for Windows that uses Linux containers. For more information, see File sharing on Docker for Mac, and the general examples on how to Manage data in containers.


10. Update the application - Because the application code is now mounted into the container using a volume, you can make changes to its code and see the changes instantly, without having to rebuild the image. Change the greeting in app.py and save it. For example, change the Hello World! message to Hello from Docker!:


11. Refresh the app in your browser. The greeting should be updated, and the counter should still be incrementing.


12. Experiment with some other commands 
    1. If you want to run your services in the background, you can pass the -d flag (for “detached” mode) to `docker compose up` and use `docker compose ps` to see what is currently running.
    2. The `docker compose run` command allows you to run one-off commands for your services. For example, to see what environment variables are available to the web service:

**Notes**  
If you started Compose with `docker compose up -d`, stop your services once you’ve finished with them `docker compose stop`  

You can bring everything down, removing the containers entirely, with the down command. Pass --volumes to also remove the data volume used by the Redis container: `docker compose down --volumes`