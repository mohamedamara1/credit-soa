# Stage 1: Build the JAR file
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml ./
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar eureka-server.jar

# Expose the default Spring Boot port for Eureka Server
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
