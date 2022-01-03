package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {

    @Test
    void getUserEmailTest() {
        User user = new NormalUser("user@example.com", "12345ABCD");
        assertEquals("user@example.com", user.getUserEmail());
    }

    @Test
    void getPasswordTest() {
        User user = new NormalUser("user@example.com", "12345ABCD");
        assertEquals("12345ABCD", user.getPassword());
    }
}