FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/company_intranet_portal-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]