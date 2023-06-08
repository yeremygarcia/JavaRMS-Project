package org.example;

import org.example.model.MenuItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public void saveMenuToFile(List<MenuItem> menuItems) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(menuItems);
            System.out.println("Menu saved to file.");
        } catch (IOException e) {
            System.out.println("Failed to save menu to file: " + e.getMessage());
        }
    }

    public List<MenuItem> loadMenuFromFile() {
        List<MenuItem> loadedMenuItems = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            loadedMenuItems = (List<MenuItem>) ois.readObject();
            System.out.println("Menu loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load menu from file: " + e.getMessage());
        }
        return loadedMenuItems;
    }
}

