# =========================
# STAGE 1 — BUILD
# =========================

FROM maven:3.9.8-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .

RUN mvn dependency:go-offline
COPY src ./src

RUN mvn clean package -DskipTests


# =========================
# STAGE 2 — RUNTIME
# =========================

FROM eclipse-temurin:21-jre

# Create non-root user
RUN groupadd -r spring && useradd -r -g spring spring

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

# Ownership
RUN chown -R spring:spring /app

USER spring

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=5s --start-period=30s CMD curl -f http://localhost:8080/actuator/health || exit 1


# JVM optimization
ENTRYPOINT ["java", \
"-XX:+UseContainerSupport", \
"-XX:MaxRAMPercentage=75.0", \
"-jar", \
"app.jar"]