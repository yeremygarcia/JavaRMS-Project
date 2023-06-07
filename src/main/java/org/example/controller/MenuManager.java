package org.example.controller;

import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
<<<<<<< HEAD:src/main/java/org/example/MenuManager.java
    private List<MenuItem> menuItems = new ArrayList<>();

    public void addItem(MenuItem item) {
        menuItems.add(item);
=======
    private Map<String, Customer.MenuItem> menuItems = new HashMap<>();

    public void addItem(Customer.MenuItem item) {
        menuItems.put(item.getItemName(), item);
>>>>>>> b456386a1ab48d9aeb04e26ec78e40d1cfe459c4:src/main/java/org/example/controller/MenuManager.java
    }

    public void removeItem(String itemName) {
        menuItems.removeIf(item -> item.getItemName().equals(itemName));
    }

<<<<<<< HEAD:src/main/java/org/example/MenuManager.java
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
=======
    public void editItem(Customer.MenuItem item) {
        // Update the existing item in the map.
        if (menuItems.containsKey(item.getItemName())) {
            menuItems.put(item.getItemName(), item);
        }
    }

    public Customer.MenuItem getItem(String itemName) {
        return menuItems.get(itemName);
>>>>>>> b456386a1ab48d9aeb04e26ec78e40d1cfe459c4:src/main/java/org/example/controller/MenuManager.java
    }
}