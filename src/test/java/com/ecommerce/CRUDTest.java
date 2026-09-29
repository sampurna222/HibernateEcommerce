package com.ecommerce;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.SessionFactory;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Users;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;
import com.ecommerce.util.HibernateUtil;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CRUDTest {

    private static SessionFactory sessionFactory;
    private static CategoryService categoryService;
    private static ProductService productService;
    private static UserService userService;

    private static Long categoryId;
    private static Long productId;
    private static Long userId;

    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        categoryService = new CategoryService(sessionFactory);
        productService = new ProductService(sessionFactory);
        userService = new UserService(sessionFactory);
    }

    @Test
    @Order(1)
    public void testCreateCategory() {
        Category category = categoryService.createCategory("Electronics Test", "Test Description");
        assertNotNull(category);
        assertNotNull(category.getId());
        categoryId = category.getId();
    }

    @Test
    @Order(2)
    public void testReadCategory() {
        Category category = categoryService.getCategory(categoryId);
        assertNotNull(category);
        assertEquals("Electronics Test", category.getName());
    }

    @Test
    @Order(3)
    public void testCreateProduct() {
        Product product = productService.createProduct("Test Laptop", new BigDecimal("50000.00"), 10, categoryId);
        assertNotNull(product);
        assertNotNull(product.getId());
        productId = product.getId();
    }

    @Test
    @Order(4)
    public void testReadProduct() {
        Product product = productService.getProduct(productId);
        assertNotNull(product);
        assertEquals("Test Laptop", product.getName());
        assertEquals(0, new BigDecimal("50000.00").compareTo(product.getPrice()));
    }

    @Test
    @Order(5)
    public void testUpdateProduct() {
        productService.updateProduct(productId, "Updated Laptop", new BigDecimal("55000.00"), 15);
        Product product = productService.getProduct(productId);
        assertNotNull(product);
        assertEquals("Updated Laptop", product.getName());
        assertEquals(15, product.getStockQuantity());
    }

    @Test
    @Order(6)
    public void testCreateUser() {
        Users user = userService.createUser("testuser", "password123", "testuser@example.com", "CUSTOMER");
        assertNotNull(user);
        assertNotNull(user.getId());
        userId = user.getId();
    }

    @Test
    @Order(7)
    public void testLoginUser() {
        Users user = userService.login("testuser", "password123");
        assertNotNull(user);
        assertEquals("testuser@example.com", user.getEmail());
    }

    @Test
    @Order(8)
    public void testDeleteProduct() {
        productService.deleteProduct(productId);
        Product product = productService.getProduct(productId);
        assertNull(product);
    }

    @Test
    @Order(9)
    public void testDeleteUser() {
        userService.deleteUser(userId);
        Users user = userService.getUser(userId);
        assertNull(user);
    }

    @AfterAll
    public static void tearDown() {
        // Cleanup remaining entities if needed
        if (categoryId != null) {
            Category cat = categoryService.getCategory(categoryId);
            if(cat != null) {
                categoryService.deleteCategory(categoryId);
            }
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
