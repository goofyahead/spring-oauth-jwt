### Runtime image ###
FROM openjdk:8-jdk-alpine

# Volume for temp Spring Boot application files
VOLUME /tmp

# Name of the service
ARG SERVICE

# Install dependencies
RUN apk add curl

# Set the app working directory
WORKDIR /app

# Copy the executable JAR to the image
COPY ${SERVICE}/build/libs/*.jar /app

# Run the app
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom ${JAVA_OPTS} -jar *.jar