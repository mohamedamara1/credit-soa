# Use Maven with OpenJDK 17 as the builder
FROM maven:3.8.3-openjdk-17 AS builder

# Set working directory
WORKDIR /app

# Copy the application source code
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Use OpenJDK 17 slim for runtime
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/app.jar .

# Expose port 8080
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
