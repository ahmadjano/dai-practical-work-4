
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
- **Komarov Sergey**: Server deployer and maintiner.

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

- Get all Todos:
  ```bash
  curl http://localhost:8080/api/todos
  ```
- Add a Todo:
  ```bash
  curl -X POST http://localhost:8080/api/todos -H "Content-Type: application/json" -d '{"title": "Buy milk"}'
  ```
- Mark a todo as completed:
  ```bash
  curl -X PUT http://localhost:8080/api/todos/{id}/completed
  ```

## Cloning and Running with Git
1. On the server, install Git: `apt-get install git`.
2. Clone the repository: `git clone https://github.com/ahmadjano/dai-practical-work-4`.
3. Follow the build and run instructions as above.
