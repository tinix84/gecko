# -------------------------------------------------------------------------
# STAGE 1: BUILD - Builds the application and creates the single 'fat' JAR.
# -------------------------------------------------------------------------
FROM maven:3-jdk-13 AS build

WORKDIR /app

# Copy the pom.xml first to leverage Docker layer caching
COPY pom.xml .

# Copy source code and build the JAR
COPY src /app/src
RUN mvn clean package -DskipTests

# -------------------------------------------------------------------------
# STAGE 2: RUNTIME - Sets up the minimal environment for the GUI application.
# -------------------------------------------------------------------------
FROM adoptopenjdk/openjdk13:ubi

# Install necessary X11 dependencies for GUI rendering (libXext, libXrender, libXtst)
RUN yum install -y libXext libXrender libXtst

# Set the primary working directory
WORKDIR /app

# Create the specific directory needed for project files and 
# dynamically compiled Java Block classes (as specified in the Makefile mount).
RUN mkdir -p /app/projects/tmp

# Copy the final application JAR from the build stage
COPY --from=build /app/target/app.jar /app/app.jar

# Define the command to run the application.
# -cp (classpath) includes app.jar AND the temporary directory (/app/projects/tmp)
# to fix the ClassNotFoundException for dynamically compiled code (tmpJav...).
# This entrypoint is crucial for dynamic class loading in the complex environment.
ENTRYPOINT ["java", "-cp", "app.jar:/app/projects/tmp", "ch.technokrat.gecko.GeckoSim"]