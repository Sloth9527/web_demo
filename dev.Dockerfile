FROM maven:3.8.1-jdk-11
WORKDIR /root/app
COPY pom.xml .
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never"]
ENTRYPOINT ["mvn","spring-boot:run"]
