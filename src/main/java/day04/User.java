package day04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private final String userName;
    private List<Item> items = new ArrayList<>();
    private double money;

    public User(String userName, double money) {
        this.userName = userName;
        this.money = money;
    }

    public void buying(Item item, LocalDate date) {
        if (item.getClass().equals(Service.class)) {
            normalBuying(item, date);
        } else if (item.getClass().equals(Product.class)) {
            if (item.getPrice() * 3 <= money) {
                extendedBuying(item, date);
            } else {
                normalBuying(item, date);
            }
        }
    }

    private void extendedBuying(Item item, LocalDate date) {
        ((Product) item).extendWarranty(date);
        items.add(item);
        item.setBought(true);
        money = money - item.getPrice();
    }

    private void normalBuying(Item item, LocalDate date) {
        if (item.getPrice() <= money) {
            item.setExpiration(date);
            items.add(item);
            item.setBought(true);
            money = money - item.getPrice();
        } else {
            throw new IllegalArgumentException("You have not enough money to buy this item: " + item);
        }
    }

    public String getUserName() {
        return userName;
    }

    public double getMoney() {
        return money;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
