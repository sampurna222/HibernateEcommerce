# Hibernate Ecommerce

A console-based e-commerce application developed using Java, Hibernate ORM, Maven, and MySQL.

## Technologies

- Java 17
- Hibernate ORM 6
- Jakarta Persistence API (JPA)
- Maven
- MySQL 8.0+
- BCrypt
- Eclipse IDE

## Setup Instructions

1. **Database Setup**:
   - Install MySQL and start the MySQL Server.
   - You can run the script located in `database/schema.sql` to manually create the database and tables.
   - Alternatively, let Hibernate generate the schema automatically (the project is configured with `hibernate.hbm2ddl.auto = update`).

2. **Configuration**:
   - Open `src/main/resources/hibernate.cfg.xml`.
   - Update `hibernate.connection.username` and `hibernate.connection.password` with your local MySQL credentials.

3. **Build the Project**:
   - Open terminal in the project directory.
   - Run `mvn clean install` to download dependencies and compile the project.

## Execution Guide

- Run the `App.java` main class to start the console application.
- The console will display a menu to manage Categories, Products, Users, and Orders. Enter the number corresponding to the action you want to perform.
- To run automated tests, execute `mvn test`.

## Project Structure

```text
HibernateEcommerce
├── src/main/java
│   └── com.ecommerce
│       ├── entity
│       ├── service
│       ├── util
│       └── App.java
│
├── src/test/java
│   └── com.ecommerce
│       └── CRUDTest.java
│
├── src/main/resources
│   └── hibernate.cfg.xml
│
├── database
│   └── schema.sql
│
├── docs
│   └── CRUD-Test-Cases.md
│
├── pom.xml
└── README.md
```