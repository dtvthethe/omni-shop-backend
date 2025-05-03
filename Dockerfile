# Build stage
FROM gradle:8.5-jdk21 AS builder
WORKDIR /app
COPY . .
RUN gradle clean bootJar

# Run stage
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

# In case pass to JAVA_OPTS or SPRING_PROFILES_ACTIVE as environment variables
ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

# -----------------------------------
# Build Docker image
# docker build -t my-kotlin-app .

# Check (with local profile)
# docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=local my-kotlin-app
