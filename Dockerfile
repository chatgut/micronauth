FROM maven:3.9.0-eclipse-temurin-19-alpine AS build
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:19-jre-alpine
COPY --from=build /app/target/micronauth.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
