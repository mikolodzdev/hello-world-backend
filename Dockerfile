FROM openjdk:8u151-jre-alpine3.7
COPY ./target/hello-world-*.jar /opt/app/app.jar
WORKDIR /opt/app
ENV APP_VERSION=$VERSION-$BUILD_START_TIME
ENV GIT_HASH=$GIT_HASH
EXPOSE 8080
ENTRYPOINT java -jar /opt/app/app.jar