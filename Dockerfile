FROM openjdk:8-jdk-alpine
ADD target/svc_project_order_api-0.0.1-SNAPSHOT.jar svc_project_order_api.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-jar","/svc_project_order_api.jar"]