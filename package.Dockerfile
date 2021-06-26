FROM jk9527/web_demo:base as builder

WORKDIR /root/app

COPY . .

RUN mvn package -o

FROM openjdk:11-jdk as prod
WORKDIR /root/app
ARG JAR_FILE=demo-app/target/*.jar
COPY --from=0 /root/app/${JAR_FILE} app.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","/root/app/app.jar"]
