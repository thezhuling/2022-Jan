FROM openjdk:11
MAINTAINER syske <thezhuling@gamil.com>
ADD target/person-service-1.0-SNAPSHOT.jar /person-service.jar
RUN bash -c 'touch /person-service.jar'
ENV TZ 'Asia/Shanghai'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/person-service.jar"]