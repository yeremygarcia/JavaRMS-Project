package org.example.controller;

import org.example.model.Customer;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private Map<String, Customer.MenuItem> menuItems = new HashMap<>();

    public void addItem(Customer.MenuItem item) {
        menuItems.put(item.getItemName(), item);
    }

    public void removeItem(String itemName) {
        menuItems.remove(itemName);
    }

    public void editItem(Customer.MenuItem item) {
        // Update the existing item in the map.
        if (menuItems.containsKey(item.getItemName())) {
            menuItems.put(item.getItemName(), item);
        }
    }

    public Customer.MenuItem getItem(String itemName) {
        return menuItems.get(itemName);
    }
}
