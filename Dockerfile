FROM java:9-b149-jdk
COPY ./target/hello-world-*.jar /opt/app/app.jar
WORKDIR ~
EXPOSE 8080
ENTRYPOINT java -jar /opt/app/app.jar