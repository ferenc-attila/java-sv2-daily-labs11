package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {

    @Test
    void getUserEmailTest() {
        NormalUser user = new NormalUser("user@example.com", "12345ABCD");
        assertEquals("user@example.com", user.getUserEmail());
    }

    @Test
    void getPasswordTest() {
        NormalUser user = new NormalUser("user@example.com", "12345ABCD");
        assertEquals("12345ABCD", user.getPassword());
    }
}