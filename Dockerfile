FROM maven:3.9.1-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY src /app/src/
COPY pom.xml /app/
COPY .mvn/ /app/.mvn/
COPY mvnw /app/
RUN chmod +x mvnw
RUN ./mvnw package -Dpackaging=docker-native -Pgraalvm
FROM eclipse-temurin:17-alpine
COPY --from=build /app/target/micronauth.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
