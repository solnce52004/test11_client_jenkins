#FROM gradle:7.3.1-jdk11 as builder
#COPY --chown=gradle:gradle . .
#RUN ./gradlew build

FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR .
ARG JAR_FILE=./build/libs/test11_client_jenkins-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 4443
ENTRYPOINT ["java","-jar","app.jar"]