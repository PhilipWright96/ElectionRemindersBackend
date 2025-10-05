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
# How To Do This

    We have extracted out the process into 3 scripts.
    1. "remove-old-image.sh" which you run from the remote server. You can run this with "sh remove-old-image.sh". This deletes the old files and docker images on the server. 
    2. "create-new-image.ps1". You can run this with 
    ".\shell-scripts\create-new-image.ps1 -Target "root@1.2.3.4:/root/" locally. Add in the correct url. This creates a image, and contains it in a local "election_reminders.tar" file, which is then sent to the remote server on the url you entered
    3. "start-new-image.sh" which you run from the remote server as "sh . This will load the tar file as a docker image and then run it. 

Need to debug a problem in the container running our app? Use docker ps to find the container id, and then run
docker logs <container_id> | less

Be aware - our remote server also has set up a "Lets Encrypt" certificate with certbot. This certificate will run out every 90 days (you can check this on the sslshopper website) so you have to manually update it by running a openssl command to regenerate the domain.12 file. We want to automate this process at some point. 

# Env and application-secrets.properties
We currently expect a application-secrets.properties file 
and a .env file. The former is for spring config and the latter is for our docker-compose file. We want to combine the 
two in the future to avoid duplicated information. 