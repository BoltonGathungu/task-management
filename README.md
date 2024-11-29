# Task Management Application - Documentation

## Overview
The **Task Management Application** is a Spring Boot-based application designed to help manage tasks, categorize them with tags, and allow users to perform CRUD operations on tasks and tags. This application supports secure authentication using JWT (JSON Web Tokens) and is structured following the MVC (Model-View-Controller) architecture.

### Key Features:
- **Task Management**: Create, update, delete, and list tasks.
- **Tag Management**: Add tags to categorize tasks.
- **User Authentication**: JWT-based authentication.
- **Database**: Uses an H2 database to persist tasks and tags.

## Technologies Used
- **Java 17+**: The programming language used to implement the application.
- **Spring Boot**: Framework for building and running the application.
- **Spring Data JPA**: For database interaction (ORM for interacting with the database).
- **Spring Security**: For authentication and authorization.
- **JWT**: For stateless authentication.
- **H2 Database**: In-memory database for development and testing.

## System Architecture

The application follows the **MVC pattern**:

1. **Model**: Represents the data (Task and Tag entities).
2. **View**: Not explicitly used in this backend application (typically this would be your front-end UI).
3. **Controller**: Handles requests and forwards them to appropriate services (not included in the provided code but could be added for the front-end interaction).

The system has two primary entities:
1. **Task**: Represents a task that can have a title, description, due date, priority, and completion status. It can be tagged with one or more tags.
2. **Tag**: Represents tags that can be assigned to tasks for categorization.

There are corresponding repositories and services for both entities that handle data persistence and business logic, respectively.

## Directory Structure

Here’s a brief overview of the directory structure:

```
com.example.task_management
├── model
│   ├── Tag.java            # Tag entity
│   └── Task.java           # Task entity
├── repository
│   ├── TagRepository.java  # Repository for Tag entity
│   └── TaskRepository.java # Repository for Task entity
├── security
│   ├── JwtAuthenticationEntryPoint.java  # Custom entry point for authentication
│   ├── JwtTokenProvider.java            # JWT token utility class
│   └── WebSecurityConfig.java           # Security configuration class
├── service
│   ├── TaskService.java      # Service handling Task business logic
│   └── TagService.java       # Service handling Tag business logic
└── TaskManagementApplication.java    # Main entry point of the application
```

## Setting Up the Application

### Prerequisites

Before you start, ensure that you have the following installed on your system:

- **Java 17+** (or newer) SDK
- **Maven** (or Gradle)
- **IDE** (Eclipse, IntelliJ, or VS Code)
- **H2 Database** (for development; no installation required, as it is embedded)

### Steps to Set Up

1. **Clone the Repository**:

   Clone the repository to your local machine:

   ```bash
   git clone https://github.com/BoltonGathungu/task-management-api.git
   ```

2. **Open the Project**:

   Open the project in your IDE (Eclipse, IntelliJ, or VS Code).

3. **Build the Project**:

   Using Maven, run the following command to build the project:

   ```bash
   mvn clean install
   ```

4. **Configure the Application** (Optional):

   You can configure the application properties in the `application.properties` file (located in `src/main/resources`) if necessary. The current setup uses an H2 in-memory database, but for production, you might want to switch to a different database like MySQL, PostgreSQL, etc.

   Example configuration for MySQL:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/task_management
   spring.datasource.username=root
   spring.datasource.password=password
   spring.jpa.hibernate.ddl-auto=update
   ```

5. **Run the Application**:

   Run the application by executing the `main()` method in `TaskManagementApplication.java` or by using Maven:

   ```bash
   mvn spring-boot:run
   ```

6. **Accessing the Application**:

   After running the application, it will be accessible at `http://localhost:8081`.

   The application exposes endpoints for task and tag management, and authentication via JWT.

## Usage

### Authentication

The application uses JWT for user authentication. To interact with the API endpoints, you must first authenticate and obtain a JWT token.

1. **Login**:
   To authenticate, send a POST request to `/auth/login` with the username and password:

   ```json
   {
     "username": "user",
     "password": "password"
   }
   ```

   **Response**:

   ```json
   {
     "token": "your-jwt-token"
   }
   ```

2. **Accessing Protected Endpoints**:
   After obtaining the token, include it in the `Authorization` header as a Bearer token for all subsequent requests:

   ```http
   Authorization: Bearer your-jwt-token
   ```

### Task API Endpoints

1. **Get all tasks**:

   GET `/tasks`

   **Response**:
   ```json
   [
     {
       "id": 1,
       "title": "Sample Task",
       "description": "Task description",
       "dueDate": "2024-12-01",
       "priority": "High",
       "completed": false,
       "tags": [{"id": 1, "name": "Urgent"}]
     }
   ]
   ```

2. **Create a new task**:

   POST `/tasks`

   **Request Body**:
   ```json
   {
     "title": "New Task",
     "description": "Description of the new task",
     "dueDate": "2024-12-15",
     "priority": "Medium",
     "completed": false,
     "tags": [{"id": 1, "name": "Important"}]
   }
   ```

   **Response**:
   ```json
   {
     "id": 2,
     "title": "New Task",
     "description": "Description of the new task",
     "dueDate": "2024-12-15",
     "priority": "Medium",
     "completed": false,
     "tags": [{"id": 1, "name": "Important"}]
   }
   ```

3. **Update a task**:

   PUT `/tasks/{taskId}`

   **Request Body**:
   ```json
   {
     "title": "Updated Task",
     "description": "Updated task description",
     "dueDate": "2024-12-20",
     "priority": "Low",
     "completed": true
   }
   ```

4. **Delete a task**:

   DELETE `/tasks/{taskId}`

### Tag API Endpoints

1. **Get all tags**:

   GET `/tags`

2. **Create a new tag**:

   POST `/tags`

   **Request Body**:
   ```json
   {
     "name": "New Tag"
   }
   ```

3. **Assign tags to a task**:

   PUT `/tasks/{taskId}/tags`

   **Request Body**:
   ```json
   {
     "tags": [{"id": 1}]
   }
   ```

4. **Get tasks by tag**:

   GET `/tasks?tag={tagName}`

### Security

- **JWT Authentication**: All endpoints except `/auth/login` are protected and require a valid JWT token to access.
- **Roles**: Currently, only basic authentication is configured with two users (`user` and `admin`), with roles assigned.

## Conclusion

This **Task Management Application** allows users to easily create and manage tasks with assigned tags, while securing all operations through JWT-based authentication. It is scalable and can be customized to fit a variety of task management needs.





