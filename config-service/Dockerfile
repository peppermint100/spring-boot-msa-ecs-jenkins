FROM openjdk:17-ea-slim AS build
WORKDIR /app

COPY ./mvnw ./mvnw
COPY ./.mvn ./.mvn
COPY ./pom.xml ./
COPY ./src ./src

RUN ./mvnw clean compile package -DskipTests=true

FROM openjdk:17-ea-slim
WORKDIR /app

COPY --from=build /app/target/config-service-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]