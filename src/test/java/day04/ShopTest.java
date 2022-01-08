package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    private Shop shop = new Shop();
    private User jane = new User("janedoe", 5000);
    private User john = new User("johndoe", 1000);
    private Item repair = new Service("repair", 1000);
    private Item rent = new Service("rent", 2000);
    private Item phone = new Product("phone", 2000);
    private Item charger = new Product("charger", 500);

    @BeforeEach
    void init() {
        shop.addUser(jane);
        shop.addUser(john);
        shop.addItem(repair);
        shop.addItem(rent);
        shop.addItem(phone);
        shop.addItem(charger);
    }

    @Test
    void possibilityOfBuyingTest() {
        assertEquals(LocalDate.now().plusMonths(3), phone.getExpiration());
        assertEquals(LocalDate.now().plusYears(1), repair.getExpiration());
        shop.possibilityOfBuying("janedoe", "phone", LocalDate.of(2019, 10, 10));
        assertEquals(1, jane.getItems().size());
        assertEquals(3000, jane.getMoney());
        assertEquals(LocalDate.of(2020,1,10), jane.getItems().get(0).getExpiration());
        shop.possibilityOfBuying("janedoe", "charger", LocalDate.of(2019,10,10));
        assertEquals(2, jane.getItems().size());
        assertEquals(2450, jane.getMoney());
        assertEquals(550, jane.getItems().get(1).getPrice());
        assertEquals(LocalDate.of(2022,10,10), jane.getItems().get(1).getExpiration());
        shop.possibilityOfBuying("janedoe", "rent", LocalDate.of(2019, 10, 10));
        assertEquals(3, jane.getItems().size());
        assertEquals(450, jane.getMoney());
        assertEquals(LocalDate.of(2020,10,10), jane.getItems().get(2).getExpiration());
    }

    @Test
    void possibilityOfBuyingNoSuchUser() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                shop.possibilityOfBuying("jackdoe", "phone", LocalDate.of(2019,10,10)));
        assertEquals("No such username in the list: jackdoe", iae.getMessage());
    }

    @Test
    void possibilityOfBuyingNoSuchItem() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () ->
                shop.possibilityOfBuying("johndoe", "laptop", LocalDate.of(2019,10,10)));
        assertEquals("No such item in stock: laptop", iae.getMessage());
    }
}