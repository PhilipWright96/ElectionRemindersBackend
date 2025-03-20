FROM eclipse-temurin:21-jre-alpine AS build

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8443

ENTRYPOINT ["java", "-jar", "app.jar"]
