# FROM eclipse-temurin:17-jdk-alpine AS builder
# WORKDIR application
# COPY mvnw .
# COPY .mvn .mvn
# COPY pom.xml .
# COPY src src
# RUN ./mvnw package -DskipTests
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} application.jar
# RUN java -Djarmode=layertools -jar application.jar extract

# FROM eclipse-temurin:17-jre-alpine
# WORKDIR application
# COPY --from=builder application/dependencies/ ./
# COPY --from=builder application/spring-boot-loader/ ./
# COPY --from=builder application/snapshot-dependencies/ ./
# COPY --from=builder application/application/ ./
# ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

# Etapa 1: Construir o executável nativo
FROM ghcr.io/graalvm/graalvm-ce:17 AS builder
RUN gu install native-image

WORKDIR application

COPY . .
RUN ./mvnw clean package -Pnative -DskipTests
ARG JAR_FILE=target/*.jar

# Etapa 2: Executar a aplicação nativa
FROM gcr.io/distroless/base-debian10
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]