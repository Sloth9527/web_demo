FROM maven:3.8.1-jdk-11 as builder

WORKDIR /root/app

ADD pom.xml .
ADD ./demo-api/pom.xml ./demo-api/pom.xml
ADD ./demo-app/pom.xml ./demo-app/pom.xml
ADD ./demo-core/pom.xml ./demo-core/pom.xml
ADD ./demo-dao/pom.xml ./demo-dao/pom.xml
ADD ./demo-server/pom.xml ./demo-server/pom.xml
ADD ./demo-test/pom.xml ./demo-test/pom.xml

RUN mvn dependency:go-offline

COPY . .

RUN mvn package -o


FROM openjdk:11-jdk as prod

WORKDIR /root/app

ARG JAR_FILE=demo-app/target/*.jar

COPY --from=0 /root/app/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/root/app/app.jar"]