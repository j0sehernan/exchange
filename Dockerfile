FROM openjdk:8-jdk-slim
COY "./target/exchange-0.0.1-SNAPSHOT.jar" "appexchange.jar"
EXPOSE 9090
ENTRYPOINT ["java","-jar","appexchange.jar"]