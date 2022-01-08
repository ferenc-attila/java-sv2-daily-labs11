package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void buyingProductWithExtendedWarrantyTest() {
        User user = new User("janet", 1000);
        Product product = new Product("phone", 100);
        user.buying(product, LocalDate.parse("2020-10-10"));
        assertEquals(1, user.getItems().size());
        assertEquals(110.0, user.getItems().get(0).getPrice(), 1);
        assertEquals("phone", user.getItems().get(0).getName());
        assertEquals(LocalDate.parse("2023-10-10"), user.getItems().get(0).getExpiration());
        assertTrue(user.getItems().get(0).isBought());
        assertTrue(((Product) (user.getItems().get(0))).isExtended());
    }

    @Test
    void buyingProductWithNormalWarrantyTest() {
        User user = new User("janet", 1000);
        Product product = new Product("phone", 500);
        user.buying(product, LocalDate.parse("2020-10-10"));
        assertEquals(1, user.getItems().size());
        assertEquals(500.0, user.getItems().get(0).getPrice(), 1);
        assertEquals("phone", user.getItems().get(0).getName());
        assertEquals(LocalDate.parse("2021-01-10"), user.getItems().get(0).getExpiration());
        assertTrue(user.getItems().get(0).isBought());
        assertFalse(((Product) (user.getItems().get(0))).isExtended());
    }

    @Test
    void buyingServiceTest() {
        User user = new User("janet", 1000);
        Service service = new Service("rent", 500);
        user.buying(service, LocalDate.parse("2020-10-10"));
        assertEquals(1, user.getItems().size());
        assertEquals(500.0, user.getItems().get(0).getPrice(), 1);
        assertEquals("rent", user.getItems().get(0).getName());
        assertEquals(LocalDate.parse("2021-10-10"), user.getItems().get(0).getExpiration());
        assertTrue(user.getItems().get(0).isBought());
    }

    @Test
    void buyingNotEnoughMoney() {
        User user = new User("janet", 1000);
        Product product = new Product("phone", 2000);
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                user.buying(product, LocalDate.of(2019, 10, 10)));
        assertEquals("You have not enough money to buy this item: Name: phone, Price: 2000.0", iae.getMessage());
    }

    @Test
    void getUserNameTest() {
        User user = new User("janet", 1000);
        assertEquals("janet", user.getUserName());
    }

    @Test
    void getMoneyTest() {
        User user = new User("janet", 1000);
        assertEquals(1000.0, user.getMoney());
    }

    @Test
    void getItemsTest() {
        User user = new User("janet", 1000);
        Product product = new Product("phone", 100);
        assertEquals(0, user.getItems().size());
        user.buying(product, LocalDate.parse("2020-10-10"));
        assertEquals(1, user.getItems().size());
        assertEquals("Name: phone, Price: 110.0", user.getItems().get(0).toString());
    }
}