FROM eclipse-temurin:25-jdk AS build

RUN apt-get update \ 
    && apt-get install -y maven \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /workspace

COPY pom.xml ./

RUN mvn -B dependency:go-offline

COPY src ./src

RUN mvn -B -T 1C clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine AS runtime

RUN addgroup -S springgroup \ 
    && adduser -S -G springgroup springuser

WORKDIR /app

COPY --from=build /workspace/target/*.jar ./app.jar

EXPOSE 8080
USER springuser

ENTRYPOINT ["java", "-jar", "/app/app.jar"]