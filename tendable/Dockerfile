# Use an OpenJDK runtime as base image
FROM openjdk:8-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy all files from the current directory to /app in the container
COPY . /app

# Compile the Java application
RUN javac *.java

# Command to run the Java application
CMD ["java", "Application"]

# Expose any ports the app needs
# EXPOSE 8080

# Healthcheck to ensure the app is running
# HEALTHCHECK --interval=30s --timeout=3s \
#   CMD curl -f http://localhost:8080/ || exit 1
