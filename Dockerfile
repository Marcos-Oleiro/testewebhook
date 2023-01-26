#
# Build stage
#
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build



COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-alpine


ENV TZ=America/Sao_Paulo

COPY --from=build /home/app/target/simulacaowebhook-0.0.1.jar /usr/local/lib/simulacaowebhook.jar
EXPOSE 8080
ENTRYPOINT  ["java","-jar","/usr/local/lib/simulacaowebhook.jar"]