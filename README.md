
# Todo List Web Application

## Introduction
This Todo List Web Application provides a simple yet powerful way to manage your daily tasks. It offers an easy-to-use API to create, update, delete, and view your todos.

## API Documentation
### Endpoints
- `GET /api/todos`: Retrieve all todos.
- `GET /api/todos/{id}`: Retrieve a specific todo by ID.
- `POST /api/todos`: Create a new todo. Requires a JSON body with the title.
- `PUT /api/todos/{id}`: Update an existing todo by ID. Requires a full JSON todo object.
- `PUT /api/todos/{id}/completed`: Mark a todo as completed.
- `DELETE /api/todos/{id}`: Delete a todo by ID.

## Team Composition
- **Ahmad Jano**: API developper.
- **Komarov Sergey**: Server deployer and maintainer.

## Installation and Configuration
### Prerequisites
- Java JDK 17
- Maven
- Docker (optional for containerization)
- Git

### Steps
1. Clone the repository: `git clone https://github.com/username/repo.git`
2. Navigate to the project directory: `cd todo-app`
3. Build the project: `mvn clean package`

## Deployment and Running the Application
1. Start the server: `java -jar target/todo-app-1.0-SNAPSHOT.jar`
2. The server will start at `http://localhost:8080`.

## DNS Zone Configuration
To configure the DNS zone for accessing the web application:
1. Update the A record in your DNS zone to point to the server's IP address.
2. Configure the server to respond to the domain name.

## Building with Docker
1. Create a Dockerfile in the project root.
2. Build the image: `docker build -t todo-app .`
3. Run the container: `docker run -p 8080:8080 todo-app`

## Interacting with the Application
Use `curl` to interact with the application. Examples:

### 1. Get All Todos
- **Endpoint:** `GET /api/todos`
- **Description:** Retrieve all todos. Can filter by completion status, title, or ID.
- **Curl Example:**
  ```bash
  # Get all todos
  curl http://localhost:8080/api/todos

  # Get todos with specific completion status (true or false)
  curl http://localhost:8080/api/todos?completed=true

  # Get todos with a specific title
  curl "http://localhost:8080/api/todos?title=Buy%20milk"

  # Get todos with a specific ID
  curl http://localhost:8080/api/todos?id=1
  ```

### 2. Get Single Todo by ID
- **Endpoint:** `GET /api/todos/{id}`
- **Description:** Retrieve a specific todo by its ID.
- **Curl Example:**
  ```bash
  curl http://localhost:8080/api/todos/1
  ```

### 3. Create a New Todo
- **Endpoint:** `POST /api/todos`
- **Description:** Create a new todo item.
- **Curl Example:**
  ```bash
  curl -X POST http://localhost:8080/api/todos -H "Content-Type: application/json" -d '{"title": "Buy milk"}'
  ```

### 4. Update an Existing Todo
- **Endpoint:** `PUT /api/todos/{id}`
- **Description:** Update the details of an existing todo.
- **Curl Example:**
  ```bash
  curl -X PUT http://localhost:8080/api/todos/1 -H "Content-Type: application/json" -d '{"title": "Buy bread", "completed": false}'
  ```

### 5. Mark a Todo as Completed
- **Endpoint:** `PUT /api/todos/{id}/completed`
- **Description:** Mark a specific todo as completed.
- **Curl Example:**
  ```bash
  curl -X PUT http://localhost:8080/api/todos/1/completed
  ```

### 6. Delete a Todo
- **Endpoint:** `DELETE /api/todos/{id}`
- **Description:** Delete a specific todo by its ID.
- **Curl Example:**
  ```bash
  curl -X DELETE http://localhost:8080/api/todos/1
  ```

## Cloning and Running with Git
1. On the server, install Git: `apt-get install git`.
2. Clone the repository: `git clone https://github.com/ahmadjano/dai-practical-work-4`.
3. Follow the build and run instructions as above.
