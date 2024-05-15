FROM maven:openjdk

LABEL authors="daniel"
LABEL description="Ranking API"

WORKDIR /app
COPY . /app

RUN mvn clean install -Dmaven.test.skip
CMD ["java", "-jar", "target/ranking-project-backend-0.0.1-SNAPSHOT.jar"]

