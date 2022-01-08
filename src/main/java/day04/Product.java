package day04;

import java.time.LocalDate;

public class Product extends Item {

    private boolean extended;

    public Product(String name, double price) {
        super(name, price);
    }

    public void extendWarranty(LocalDate dateOfBuying) {
        extended = true;
        expiration = dateOfBuying.plusMonths(36);
        this.setPrice(1.1);
    }

    @Override
    public void setExpiration(LocalDate dateOfBuying) {
        expiration = dateOfBuying.plusMonths(3);
    }

    @Override
    public LocalDate getExpiration() {
        if (!isBought()) {
            return LocalDate.now().plusMonths(3);
        } else {
            return expiration;
        }
    }

    public boolean isExtended() {
        return extended;
    }
}
