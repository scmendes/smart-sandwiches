FROM java:8
MAINTAINER Silvio Mendes
VOLUME /tmp
ADD smart-sandwiches-1.0.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]