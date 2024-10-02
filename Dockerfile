FROM amazoncorretto:17-al2-jdk

COPY build/libs/unimarket-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar" , "/app.jar"]

