FROM maven:3.8.6-openjdk-18-slim AS build

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY src $APP_HOME/src
COPY pom.xml $APP_HOME
RUN mvn -f $APP_HOME/pom.xml clean package

FROM eclipse-temurin:17-jre-alpine

ENV APP_HOME=/usr/app
WORKDIR $APP_HOME

COPY --from=build $APP_HOME/target/sample-broker.jar .
CMD ["javai", "-jar", "sample-broker.jar"]
