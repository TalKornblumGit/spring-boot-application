FROM openjdk:8
ADD target/proj-0.0.1-SNAPSHOT.jar docker.jar
ENTRYPOINT ["java","-jar","docker.jar"]
EXPOSE 8080