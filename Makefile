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

export:
	@echo "📦 Exporting build artifacts to ./dist..."
	@DOCKER_BUILDKIT=1 docker build --target build --output type=local,dest=./dist .

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