# CRUD Test Cases

This project uses **JUnit 5** to verify all CRUD (Create, Read, Update, Delete) operations.

## Test Class: `CRUDTest.java`

The test file is located at: `src/test/java/com/ecommerce/CRUDTest.java`.

### Executed Tests

1. **`testCreateCategory`**: Ensures that a category can be inserted into the database.
2. **`testReadCategory`**: Confirms that a previously inserted category can be retrieved by ID.
3. **`testCreateProduct`**: Verifies that a product can be inserted and associated with an existing category.
4. **`testReadProduct`**: Ensures the product properties match what was saved.
5. **`testUpdateProduct`**: Updates the product's name, price, and stock, then verifies the update.
6. **`testCreateUser`**: Asserts that a user can be successfully registered, and the password is automatically hashed.
7. **`testLoginUser`**: Authenticates the user with BCrypt to verify password hashing and retrieval.
8. **`testDeleteProduct`**: Deletes the product and verifies it can no longer be found.
9. **`testDeleteUser`**: Deletes the user and verifies it no longer exists.

### How to Run Tests

You can run the tests using Maven via your command prompt or terminal:
```bash
mvn test
```

Or you can run `CRUDTest.java` directly in your IDE (e.g., Eclipse or IntelliJ IDEA) by right-clicking the file and selecting **Run As -> JUnit Test**.
