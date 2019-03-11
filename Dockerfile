FROM openjdk:8-alpine

COPY target/uberjar/restapi-app.jar /restapi-app/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/restapi-app/app.jar"]
