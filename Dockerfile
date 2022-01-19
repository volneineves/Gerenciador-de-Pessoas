FROM openjdk:11-jdk
MAINTAINER Volnei Neves
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]