# syntax=docker/dockerfile:1

# Build stage
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (cached layer)
COPY pom.xml .
RUN mvn -q -e -B -DskipTests dependency:go-offline

# Copy source code and build the application
COPY src ./src
RUN mvn -q -e -B -DskipTests package

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

