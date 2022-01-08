package day04;

import java.time.LocalDate;

public abstract class Item {

    private String name;
    private double price;
    protected LocalDate expiration;
    private boolean isBought = false;

    protected Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + Math.round(price * 10.0) / 10.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double multiplier) {
        this.price = price * multiplier;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public LocalDate getExpiration() {
        if (!isBought()) {
            return LocalDate.now().plusYears(1);
        } else {
            return expiration;
        }
    }

    public abstract void setExpiration(LocalDate dateOfBuying);
}
