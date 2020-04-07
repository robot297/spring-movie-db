FROM maven:3.6.3-jdk-11

COPY . /
RUN mvn clean package

FROM openjdk:11.0.6-jre
EXPOSE 8080
COPY --from=0 /target/*.jar /
CMD java -jar *.jar
