# Deploy the word-ladder onto docker
## Instruction
```
cd word-ladder
mvn package docker:build
docker run -p 8080:8080 -t springboot/word-ladder
```

## Dockerfile

```
FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD word-ladder-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

```

## Pull docker image form Dockerhub

```
docker pull dianaaaa/word-ladder
docker run -p 8080:8080 -t dianaaaa/word-ladder
```