package day04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Item> items = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public void addItem (Item item) {
        items.add(item);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void possibilityOfBuying (String userName, String itemName, LocalDate date) {
        User user = getUserByUserName(userName);
        Item item = getItemByName(itemName);
        user.buying(item, date);
    }

    private User getUserByUserName (String userName) {
        for (User actual : users) {
            if (userName.equals(actual.getUserName())) {
                return actual;
            }
        }
        throw new IllegalArgumentException("No such username in the list: " + userName);
    }

    private Item getItemByName (String itemName) {
        for (Item actual : items) {
            if (itemName.equals(actual.getName())) {
                return getCopyOfItem(actual);
            }
        }
        throw new IllegalArgumentException("No such item in stock: " + itemName);
    }

    private Item getCopyOfItem(Item item) {
        if (item.getClass().equals(Product.class)) {
            return new Product(item.getName(), item.getPrice());
        }
        if (item.getClass().equals(Service.class)) {
            return new Service(item.getName(), item.getPrice());
        }
        throw new IllegalArgumentException("Invalid item type: " + item.getClass());
    }
}
