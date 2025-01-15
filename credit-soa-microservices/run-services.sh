#!/bin/bash

echo "Starting all microservices..."

# Function to navigate to a directory and start the service
start_service() {
  local service_dir="$1"
  local service_name="$2"

  echo "Starting $service_name..."
  (
    cd "$service_dir" || exit
    gnome-terminal -- bash -c "mvn spring-boot:run; exec bash"
  )
}

# Start Bareme Service
start_service "bareme-service" "Bareme Service"

# Start Client Service
start_service "client-service" "Client Service"

# Start Credit Service
start_service "credit-service" "Credit Service"

# Start Score Decision Service
start_service "score-decision-service" "Score Decision Service"

# Start Decision Service
start_service "decision-service" "Decision Service"

echo "All services started."
