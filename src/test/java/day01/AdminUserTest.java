package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdminUserTest {

    @Test
    void getUserEmailTest() {
        User admin = new AdminUser("admin@example.com", "ABCD12345");
        assertEquals("admin@example.com", admin.getUserEmail());

    }

    @Test
    void getPasswordTest() {
        User admin = new AdminUser("admin@example.com", "ABCD12345");
        assertEquals("*********", admin.getPassword());
    }
}