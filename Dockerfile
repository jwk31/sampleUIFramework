#
# Build stage
#
FROM maven:3.8.6-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
#RUN ls -la
#WORKDIR /home/app/target
#ENTRYPOINT ["java","-jar","sampleUIFramework-1.0-SNAPSHOT.jar"]

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/dtest2.jar /usr/local/lib/dt2.jar
WORKDIR /usr/local/lib
EXPOSE 8080
ENTRYPOINT ["java","-jar","dt2.jar"]