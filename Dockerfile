FROM openjdk:8-jdk-alpine
ADD target/svc_project_order_api-2.0.1-SNAPSHOT.jar svc-project-order-api.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/svc-project-order-api.jar"]