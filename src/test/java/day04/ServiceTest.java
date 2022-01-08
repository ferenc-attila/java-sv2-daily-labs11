package day04;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void setExpirationTest() {
        Service service = new Service("rent", 2000);
        assertEquals(LocalDate.now().plusYears(1), service.getExpiration());
        service.setExpiration(LocalDate.parse("2020-10-10"));
        service.setBought(true);
        assertEquals(LocalDate.parse("2021-10-10"), service.getExpiration());
    }
}