package day04;

import java.time.LocalDate;

public class Service extends Item {

    public Service(String name, double price) {
        super(name, price);
    }

    @Override
    public void setExpiration(LocalDate dateOfBuying) {
        this.expiration = dateOfBuying.plusYears(1);
    }
}
