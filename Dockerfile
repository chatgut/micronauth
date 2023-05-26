FROM maven:3.9.0-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY src /app/src/
COPY pom.xml /app/
RUN ./mvnw package -Dpackaging=docker-native -Pgraalvm
FROM adoptopenjdk/openjdk17:alpine-jre
COPY --from=build /app/target/micronauth.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
