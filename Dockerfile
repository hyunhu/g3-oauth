FROM openjdk:17-jdk-alpine
VOLUME /tmp
MAINTAINER hyunhu
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} g3-users-0.0.1-SNAPSHOT.jar
EXPOSE 8099
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/g3-users-0.0.1-SNAPSHOT.jar"]