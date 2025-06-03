# Stage 1: Build
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN chmod +x ./gradlew && ./gradlew build -x test --no-daemon

# Stage 2: Run
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/consulta-creditos-backend-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8152

ENTRYPOINT ["java", "-jar", "app.jar"]
