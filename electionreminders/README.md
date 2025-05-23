# ElectionRemindersBackend
# ElectionReminders

# Goal: 
To create a mobile app which offers the user the ability to set up reminders for important elections (local and national). In this repo, we have the backend logic for this app (written with Java and Spring Boot)

# Technology: 
Java 21, Maven 3.8.5, Spring Boot, SQL 

# How to get started: 
Firstly build the project. You can do this with the VSCODE IDE when you simply press shift,ctrl, p and select the "Java: Rebuild Projects" command.
Then simply start the application in "Application.java". Right now - this will turn on a few test endpoints 
which will run on localhost:8443. The app is running on ssh to allow for testing purposes. To run the app, you also need a application.properties file and associated .jks (Java keystore)files and .p12 (PKCS) files. Front end components can call these endpoints and receive dummy data.  The startpoint for the app is "Application.java". 

# Database logic. 
The programme uses a sql database to return elections. Please start a sql database (I use pgadmin) beforehand. 

# application.properties and settings.
This app has multiple settings. You can view what settings are needed in application.properties. You can add the necessary
passwords and sensitive data in a application-secrets.properties file. 

# Docker
This repo has a Dockerfile for building the Spring App as a jar. It also has a docker-compose file for building and running
the necessary containers (the app and Postgres). Just run "docker-compose up -d --build". When the containers are running,
you can access them via the rest endpoints we provide. You can also view our logging in the docker files with "docker logs". 

# Hetzner
We have a server in the Cloud (Hetzner) where we can run our application. If you want to test with it, be sure to 
switch it on and to turn on the docker containers inside it. Then you can call endpoints against it to check its working. If you want to make changes, you can generate tar files from the images and then ssh them into the remote server. 
    How To Do This
    1. Clear out the images from the remote server (delete tar files and run docker-compose down, and run "docker system prune -a --volumes").
    2. Regenerate jar file with "mvn clean package". 
    3. Rebuild and run docker images with docker compose up -d --build
    4. Then run "docker save"  to generate images as tar files from the local running containers. 
    5. Then ssh those images into the remote server with the scp command.  
    6. Use "docker load" to convert those tar files into proper images which can be locally accessed. 
    7. Then on the remote server, you can run docker compose up. 

This process is pretty manual and annoying. We are working on automating this process better. Ideally, things should be tested locally anyway. 


# Env and application-secrets.properties
We currently expect a application-secrets.properties file 
and a .env file. The former is for spring config and the latter is for our docker-compose file. We want to combine the 
two in the future to avoid duplicated information. 