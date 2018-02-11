FROM openjdk:8u151-jre-alpine3.7
COPY ./target/hello-world-*.jar /opt/app/app.jar
WORKDIR /opt/app
EXPOSE 8080
ENTRYPOINT java -jar /opt/app/app.jar