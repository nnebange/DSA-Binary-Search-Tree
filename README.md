# DSA-Binary-Search-Tree
## Balanced Binary Search Tree (BST) Web Application

---

## Project Description:

This is a Spring Boot based web application developed for the "Data Structures and Algorithms" course project.

### Purpose:
- Allow users to enter a series of numbers.
- Automatically create a Balanced Binary Search Tree (BST) from those numbers.
- View the resulting tree in a structured JSON format.
- Store and view previous trees created using an H2 database.
- Perform basic unit testing of functionality.

---

## Features:

- Insert numbers (comma-separated) to create BST.
- Balance the tree automatically.
- Return the tree structure as JSON.
- View all previous trees from the database.
- In-memory H2 database used.
- Unit testing included.

---

## Technologies Used:

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 In-Memory Database
- Thymeleaf (HTML Templating)
- Maven
- JUnit 5 (Testing)
- Lombok

---

## How To Run The Project Locally:

### 1. Clone the Repository:
```sh
git clone https://github.com/nnebange/DSA-Binary-Search-Tree.git
```

```sh
cd DSA-Binary-Search-Tree
```

**Build the Project**
```sh
mvn clean install
```

**Run the Application**
```sh
mvn spring-boot:run
```

**Access application**
```sh
http://localhost:8080/enter-numbers
```
