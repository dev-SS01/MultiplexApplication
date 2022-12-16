# define base docker image
FROM openjdk:11
COPY MultiplexProject-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar","/app/MultiplexProject-0.0.1-SNAPSHOT.jar"]
