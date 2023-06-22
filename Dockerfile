FROM openjdk:17

EXPOSE 8080
VOLUME /tmp
COPY target/HospitalAPI-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]