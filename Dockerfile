FROM amazoncorretto:17-alpine
LABEL authors="Sthabile"
#
ARG springProfile=local
ENV SPRING_PROFILES_ACTIVE=$springProfile

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
