FROM openjdk:12-alpine

LABEL maintainer="partha.cemk@gmail.com"

COPY target/active-mq-example-0.0.1-SNAPSHOT.jar /home/active-mq-example-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","/home/active-mq-example-0.0.1-SNAPSHOT.jar"]