# Use uma imagem base do JDK 8
FROM openjdk:8-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o arquivo JAR do aplicativo para o diretório de trabalho
COPY target/Locadora-1.0.jar /app/Locadora-1.0.jar

# Exponha a porta em que o aplicativo Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar o aplicativo
CMD ["java", "-jar", "Locadora-1.0.jar"]