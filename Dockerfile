FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

# Copy the JAR file built by Maven
COPY target/*.jar app.jar

# Run the application
CMD ["java", "-jar", "app.jar"]