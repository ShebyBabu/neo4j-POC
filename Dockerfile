FROM openjdk:11-jdk-stretch

WORKDIR /src/main/i2ps

ADD ./target/i2ps-0.0.1-SNAPSHOT.jar   /src/main/i2ps/i2ps-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","i2ps-0.0.1-SNAPSHOT.jar"]