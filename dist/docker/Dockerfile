FROM openjdk

WORKDIR /app
COPY service-app/build/libs/service-fat.jar service.jar
CMD ["java", "-jar", "service.jar"]