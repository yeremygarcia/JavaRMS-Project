package org.example;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String itemName;
    private String itemDescription;
    private double preparationTime;
    private double itemPrice;
    private List<String> ingredients;

    public MenuItem(String itemName, String itemDescription, double preparationTime, double itemPrice, List<String> ingredients) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.preparationTime = preparationTime;
        this.itemPrice = itemPrice;
        this.ingredients = ingredients;
    }

    // Getters, Setters...

    public String getItemName() {
        return itemName;
    }
    public String getName() {
        return getName();
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setPreparationTime(double preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public static void saveMenu(List<MenuItem> menu, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\admin\\Documents\\CTAC-Program\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (MenuItem item : menu) {
                bufferedWriter.write(item.getItemName() + ",");
                bufferedWriter.write(item.getItemDescription() + ",");
                bufferedWriter.write(item.getPreparationTime() + ",");
                bufferedWriter.write(item.getItemPrice() + ",");
                for (String ingredient : item.getIngredients()) {
                    bufferedWriter.write(ingredient + ";");
                }
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
            System.out.println("Menu saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving menu: " + e.getMessage());
        }
    }

    public static List<MenuItem> loadMenu(String fileName) {
        List<MenuItem> menu = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("C:\\Users\\klee9\\CTAC\\Day66\\Project\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String itemName = parts[0];
                    String itemDescription = parts[1];
                    double preparationTime = Double.parseDouble(parts[2]);
                    double itemPrice = Double.parseDouble(parts[3]);
                    List<String> ingredients = new ArrayList<>();

                    if (parts.length >= 5) {
                        String[] ingredientParts = parts[4].split(";");
                        for (String ingredient : ingredientParts) {
                            ingredients.add(ingredient);
                        }
                    }

                    MenuItem item = new MenuItem(itemName, itemDescription, preparationTime, itemPrice, ingredients);
                    menu.add(item);
                }
            }

            bufferedReader.close();
            fileReader.close();
            System.out.println("Menu loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading menu: " + e.getMessage());
        }
        return menu;
    }

}