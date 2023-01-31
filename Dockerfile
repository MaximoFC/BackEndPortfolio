FROM amazoncorretto:19-alpine-jdk
MAINTAINER maximo
COPY target/mfc2-0.0.1-SNAPSHOT.jar mfc-app.jar
ENTRYPOINT ["java","-jar","/mfc-app.jar"]