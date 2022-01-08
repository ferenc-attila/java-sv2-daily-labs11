package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void extendWarrantyTest() {
        Product product = new Product("phone", 200);
        product.extendWarranty(LocalDate.parse("2020-10-10"));
        product.setBought(true);
        assertEquals(LocalDate.parse("2023-10-10"), product.getExpiration());
        assertTrue(product.isExtended());
    }

    @Test
    void setExpirationTest() {
        Product product = new Product("phone", 100);
        assertEquals(LocalDate.now().plusMonths(3), product.getExpiration());
        product.setExpiration(LocalDate.parse("2020-10-10"));
        product.setBought(true);
        assertEquals(LocalDate.parse("2021-01-10"), product.getExpiration());
        assertFalse(product.isExtended());
    }

    @Test
    void isExtendedTest() {
        Product product = new Product("phone", 100);
        assertFalse(product.isExtended());
    }
}