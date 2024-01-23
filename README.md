
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
1. Clone the repository: `git clone https://github.com/ahmadjano/todos-app
2. Navigate to the project directory.
3. Build the project: `mvn clean package`

## Deployment and Running the Application
### On the server
1. Build the traefik container image: `docker compose -f traefik/docker-compose.yml up --build`. This will start the traefik reverse proxy server.
2. Build the app container image: `docker compose up --build`. This will start the web application server.
3. The server will start at `http://web.shadyseko.dedyn.io`.

## DNS Zone Configuration
To configure the DNS zone for accessing the web application:
1. Update the A record in your DNS zone to point to the server's IP address.
2. Configure the server to respond to the domain name.

## In our configuration:
  The server is already accessible via the URL above.
  The server is running on a virtual machine, so to test the api, you
  can simply follow the following: 

## Interacting with the Application
Use `curl` to interact with the application. Examples:

### 1. Get All Todos
- **Endpoint:** `GET /api/todos`
- **Description:** Retrieve all todos. Can filter by completion status, title, or ID.
- **Curl Example:**
  ```bash
  # Get all todos
  curl http://web.shadyseko.dedyn.io/api/todos

  # Get todos with specific completion status (true or false)
  curl http://web.shadyseko.dedyn.io/api/todos?completed=true

  # Get todos with a specific title
  curl "http://web.shadyseko.dedyn.io/api/todos?title=Buy%20milk"

  # Get todos with a specific ID
  curl http://web.shadyseko.dedyn.io/api/todos?id=1
  ```

### 2. Get Single Todo by ID
- **Endpoint:** `GET /api/todos/{id}`
- **Description:** Retrieve a specific todo by its ID.
- **Curl Example:**
  ```bash
  curl http://web.shadyseko.dedyn.io/api/todos/1
  ```

### 3. Create a New Todo
- **Endpoint:** `POST /api/todos`
- **Description:** Create a new todo item.
- **Curl Example:**
  ```bash
  curl -X POST \
    -H "Content-Type: application/json" \
    -d '{"title": "Buy milk"}' \
    http://web.shadyseko.dedyn.io/api/todos
  ```

### 4. Update an Existing Todo
- **Endpoint:** `PUT /api/todos/{id}`
- **Description:** Update the details of an existing todo.
- **Curl Example:**
  ```bash
  curl -X PUT \
    -H "Content-Type: application/json" \
    -d '{"title": "Buy bread", "completed": false}' \
    http://web.shadyseko.dedyn.io/api/todos/1
  ```

### 5. Mark a Todo as Completed
- **Endpoint:** `PUT /api/todos/{id}/completed`
- **Description:** Mark a specific todo as completed.
- **Curl Example:**
  ```bash
  curl -X PUT http://web.shadyseko.dedyn.io/api/todos/1/completed
  ```

### 6. Delete a Todo
- **Endpoint:** `DELETE /api/todos/{id}`
- **Description:** Delete a specific todo by its ID.
- **Curl Example:**
  ```bash
  curl -X DELETE http://web.shadyseko.dedyn.io/api/todos/1
  ```
## Little hint
Upon recieving the HTTP responses via curl in the terminal, it can be useful to pipe the response to a json parser, like jq for example for more readability

## Cloning and Running with Git
1. On the server, install Git: `apt-get install git`.
2. Clone the repository: `git clone https://github.com/ahmadjano/dai-practical-work-4`.
3. Follow the build and run instructions as above.
