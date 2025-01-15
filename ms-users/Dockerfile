#FROM ubuntu:latest
#LABEL authors="oahmam"
#
#ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:17.0.13_11-jdk-alpine

ARG JAR_FILE=target/ms-users-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ms-user.jar

ENTRYPOINT ["java", "-jar", "ms-user.jar"]