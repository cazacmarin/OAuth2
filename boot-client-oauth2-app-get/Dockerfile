FROM maven:3.6.3-jdk-8 AS build
WORKDIR /usr/src/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package

FROM openjdk:8-jdk-slim

# Add a  user to run the application so that it doesn't need to run as root
RUN adduser --gecos '' --disabled-password --shell /bin/sh marin
WORKDIR /home/marin

COPY --from=build /usr/src/app/target/boot-client-0.0.1.war /home/marin/boot-client.war

RUN chmod +x /home/marin/boot-client.war

USER marin

ENTRYPOINT ["java", "-jar", "boot-client.war"]

EXPOSE 8090

