FROM maven:3.8.1-jdk-11 as builder
WORKDIR /root/app
COPY pom.xml .
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
COPY . .
RUN mvn package

FROM openjdk:11-jdk as prod
WORKDIR /root/app
ARG JAR_FILE=target/*.jar
COPY --from=0 /root/app/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/root/app/app.jar"]