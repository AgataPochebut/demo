FROM openjdk:11

ADD ./target/demo.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]