FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /target/diamonds-0.0.1-SNAPSHOT.jar /diamonds-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo/DiamondMarket","-Djava.security.egd=file:/dev/./urandom","-jar","/diamonds-0.0.1-SNAPSHOT.jar"]
 