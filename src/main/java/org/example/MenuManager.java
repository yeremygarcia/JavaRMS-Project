package org.example;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private Map<String, MenuItem> menuItems = new HashMap<>();

    public void addItem(MenuItem item) {
        menuItems.put(item.getItemName(), item);
    }

    public void removeItem(String itemName) {
        menuItems.remove(itemName);
    }

    public void editItem(MenuItem item) {
        // Update the existing item in the map.
        if (menuItems.containsKey(item.getItemName())) {
            menuItems.put(item.getItemName(), item);
        }
    }

    public MenuItem getItem(String itemName) {
        return menuItems.get(itemName);
    }
}

