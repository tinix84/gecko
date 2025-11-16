# -------------------------------------------------------------------------
# STAGE 1: BUILD - Builds the application and creates the single 'fat' JAR.
# -------------------------------------------------------------------------
FROM maven:3-jdk-13 AS build

WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn clean package -DskipTests

# -------------------------------------------------------------------------
# STAGE 2: RUNTIME - Sets up the minimal environment for the GUI application.
# -------------------------------------------------------------------------
FROM adoptopenjdk/openjdk13:ubi

# Install necessary X11 dependencies using YUM (the package manager for UBI)
# Note: openjdk13 is already included in the base image.
RUN yum install -y libXext libXrender libXtst && \
    yum clean all

# Set the primary working directory
WORKDIR /app

# Create the specific directory needed for project files and compiled classes.
RUN mkdir -p /app/projects/tmp

# Copy the final application JAR from the build stage
COPY --from=build /app/target/app.jar /app/app.jar

# Define the command to run the application.
ENTRYPOINT ["java", "-cp", "app.jar:/app/projects/tmp", "ch.technokrat.gecko.GeckoSim"]