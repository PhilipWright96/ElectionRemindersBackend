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