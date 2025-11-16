# --- Configuration Variables ---
IMAGE_NAME       := gecko-image
IMAGE_TAG        := 1.0
CONTAINER_NAME   := gecko-app
# Path on the host machine where circuit projects will be stored
HOST_PROJECT_DIR := ./my_circuit_projects
# Internal path inside the container for projects (used for the volume mount)
CONTAINER_PROJECT_DIR := /app/projects

# Phony targets are targets that do not correspond to an actual file.
.PHONY: build run stop export clean ls help

# Default target
all: build

# --- Docker Targets ---

install:
	@echo "⚙️ Installing system dependencies (GUI libs & Java)..."
	@sudo apt update
	@sudo apt install -y libxext6 libxrender1 libxtst6 openjdk-17-jdk
	@echo "⬇️ Downloading Nashorn & its ASM dependencies..."
	@mkdir -p ./lib
	@curl -L -o ./lib/nashorn-core.jar https://repo.maven.apache.org/maven2/org/openjdk/nashorn/nashorn-core/15.4/nashorn-core-15.4.jar
	@curl -L -o ./lib/asm.jar https://repo.maven.apache.org/maven2/org/ow2/asm/asm/7.3.1/asm-7.3.1.jar
	@curl -L -o ./lib/asm-util.jar https://repo.maven.apache.org/maven2/org/ow2/asm/asm-util/7.3.1/asm-util-7.3.1.jar
	@curl -L -o ./lib/asm-commons.jar https://repo.maven.apache.org/maven2/org/ow2/asm/asm-commons/7.3.1/asm-commons-7.3.1.jar
	@curl -L -o ./lib/asm-tree.jar https://repo.maven.apache.org/maven2/org/ow2/asm/asm-tree/7.3.1/asm-tree-7.3.1.jar
	@curl -L -o ./lib/asm-analysis.jar https://repo.maven.apache.org/maven2/org/ow2/asm/asm-analysis/7.3.1/asm-analysis-7.3.1.jar
	@echo "✅ Dependencies installed."

build:
	@echo "🏗️ Building Docker image: $(IMAGE_NAME):$(IMAGE_TAG)..."
	@docker build -t $(IMAGE_NAME):$(IMAGE_TAG) .

run:
	@mkdir -p $(HOST_PROJECT_DIR)
	@echo "🖥️ Allowing Docker to connect to X display..."
	@xhost +local: > /dev/null
	@echo "🚀 Running GUI application as container: $(CONTAINER_NAME)..."
	@docker run --rm \
		--name $(CONTAINER_NAME) \
		-e DISPLAY=$(DISPLAY) \
		-e JAVA_TOOL_OPTIONS="-Djava.io.tmpdir=$(CONTAINER_PROJECT_DIR)/tmp" \
		-v /tmp/.X11-unix:/tmp/.X11-unix \
		-v "$(PWD)/$(HOST_PROJECT_DIR):$(CONTAINER_PROJECT_DIR):z" \
		$(IMAGE_NAME):$(IMAGE_TAG)
	@echo "🔒 Restoring X display permissions..."
	@xhost -local: > /dev/null

stop:
	@echo "🛑 Stopping container: $(CONTAINER_NAME)..."
	@docker stop $(CONTAINER_NAME) || true

run-local:
	@java -cp ./release/app.jar:./projects/tmp:./lib/* ch.technokrat.gecko.GeckoSim

export:
	@echo "📦 Generating standalone JAR for native execution..."
	@mkdir -p ./release
	# 1. Build the image for the 'build' stage and tag it temporarily
	@docker build --target build -t $(IMAGE_NAME)-build-temp . > /dev/null
	# 2. Create a temporary container from the build stage image
	@docker create --name artifact-extractor $(IMAGE_NAME)-build-temp > /dev/null
	# 3. Copy the specific JAR file out of the container to the host's ./release folder
	@docker cp artifact-extractor:/app/target/app.jar ./release/
	# 4. Clean up: remove the temporary container and image
	@docker rm artifact-extractor > /dev/null
	@docker rmi $(IMAGE_NAME)-build-temp > /dev/null
	@echo "✅ JAR successfully extracted to ./release/app.jar"
	@echo "Note: To run natively on Ubuntu, ensure OpenJDK 17 or higher is installed."

ls:
	@echo "--- 📂 Listing files in $(CONTAINER_PROJECT_DIR) (inside container $(CONTAINER_NAME)) ---"
	@docker exec $(CONTAINER_NAME) ls -al $(CONTAINER_PROJECT_DIR) || \
		(echo "Error: Container $(CONTAINER_NAME) not found or not running." && exit 1)

clean:
	@echo "🗑️ Removing Docker image: $(IMAGE_NAME):$(IMAGE_TAG)..."
	@docker rmi $(IMAGE_NAME):$(IMAGE_TAG) 2>/dev/null || echo "Image not found, skipping removal."
	@rm -rf dist target

help:
	@echo "Usage: make <target>"
	@echo ""
	@echo "Targets:"
	@echo "  build    : Builds the Docker image ($(IMAGE_NAME):$(IMAGE_TAG))."
	@echo "  run      : Runs the container with X-server access and volume mount."
	@echo "  stop     : Stops the running container ($(CONTAINER_NAME))."
	@echo "  export   : Exports build artifacts from a multi-stage build to ./dist."
	@echo "  ls       : Lists contents of the project directory inside the running container."
	@echo "  clean    : Removes the local Docker image."