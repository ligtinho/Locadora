
FROM openjdk:8-jdk-slim

WORKDIR /app

COPY target/Locadora-1.0.jar /app/Locadora-1.0.jar

EXPOSE 8080

CMD ["java", "-jar", "Locadora-1.0.jar"]