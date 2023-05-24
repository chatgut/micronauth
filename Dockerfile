FROM eclipse-temurin:20-jre-alpine
COPY target/*.jar app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]