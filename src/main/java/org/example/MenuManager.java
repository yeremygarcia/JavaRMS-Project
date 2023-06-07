package org.example;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public void removeItem(String itemName) {
        menuItems.removeIf(item -> item.getItemName().equals(itemName));
    }

    public void editItem(MenuItem item) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getItemName().equals(item.getItemName())) {
                menuItems.set(i, item);
                break;
            }
        }
    }

    public MenuItem getItem(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }
}