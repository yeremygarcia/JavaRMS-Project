package org.example.services;

import org.example.model.MenuItem;
import org.example.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    private Scanner scanner;
    private List<MenuItem> menuItems;
    private static final String MENU_FILE_PATH = "menu.txt";

    public MenuService() {
        this.scanner = new Scanner(System.in);
        this.menuItems = new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void showMainMenu() {
        System.out.println("1. Log in");
        System.out.println("2. Register Manager");
        System.out.println("3. Register Staff");
        System.out.println("4. Manage Menu");
        System.out.println("5. Process Order");
        System.out.println("6. Manage Table");
        System.out.println("7. Manage Inventory");
        System.out.println("8. Generate Sales Report");
        System.out.println("9. Log out");
        System.out.println("0. Exit");
    }

    public int getChoice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice > 9) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number from 0 to 9.");
        }
        return choice;
    }

    public int showMainMenuAndGetChoice() {
        // Display the main menu
        showMainMenu();

        // Get the user's choice
        int choice = getChoice();

        return choice;
    }

    public void manageMenu() {
        while (true) {
            // Show the menu management menu and get the user's choice
            showMenuManagementMenu();
            int choice = getMenuManagementChoice();

            switch (choice) {
                case 1:
                    addMenuItem();
                    break;

                case 2:
                    removeMenuItem();
                    break;

                case 3:
                    editMenuItem();
                    break;

                case 4:
                    displayMenu();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private void showMenuManagementMenu() {
        System.out.println("1. Add Menu Item");
        System.out.println("2. Remove Menu Item");
        System.out.println("3. Edit Menu Item");
        System.out.println("4. Display Menu");
        System.out.println("5. Exit");
    }

    private int getMenuManagementChoice() {
        int choice = 0;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 5) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number from 1 to 4.");
        }
        return choice;
    }

    private void addMenuItem() {
        System.out.print("Enter the name of the new menu item: ");
        String name = scanner.nextLine();
        System.out.print("Enter the description of the new menu item: ");
        String description = scanner.nextLine();
        System.out.print("Enter the price of the new menu item: ");
        double price = scanner.nextDouble();
        System.out.print("Enter the prep time of the new menu item (in minutes): ");
        int prepTime = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        System.out.print("Enter the number of ingredients: ");
        int ingredientCount = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i < ingredientCount; i++) {
            System.out.print("Enter ingredient #" + (i + 1) + ": ");
            String ingredient = scanner.nextLine();
            ingredients.add(ingredient);
        }

        MenuItem newItem = new MenuItem(name, description, price, prepTime, ingredients);
        menuItems.add(newItem);
        saveMenuItemsToFile();
        System.out.println("New menu item added successfully.");
    }

    private void removeMenuItem() {
        System.out.print("Enter the index of the menu item to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        if (index >= 0 && index < menuItems.size()) {
            MenuItem removedItem = menuItems.remove(index);
            System.out.println("Menu item removed: " + removedItem);
            saveMenuItemsToFile();
        } else {
            System.out.println("Invalid menu item index.");
        }
    }

    private void editMenuItem() {
        System.out.print("Enter the index of the menu item to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        if (index >= 0 && index < menuItems.size()) {
            MenuItem item = menuItems.get(index);
            System.out.println("Current menu item: " + item);

            System.out.print("Enter the new name (or press Enter to keep the current name): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                item.setItemName(newName);
            }

            System.out.print("Enter the new price (or press Enter to keep the current price): ");
            String newPriceString = scanner.nextLine();
            if (!newPriceString.isEmpty()) {
                try {
                    double newPrice = Double.parseDouble(newPriceString);
                    item.setItemPrice(newPrice);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price format. The price was not modified.");
                }
            }

            System.out.println("Menu item updated: " + item);
            saveMenuItemsToFile();
        } else {
            System.out.println("Invalid menu item index.");
        }
    }

    public void saveMenuItemsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(MENU_FILE_PATH))) {
            for (MenuItem item : menuItems) {
                writer.write(item.getName() + "," + item.getDescription() + "," + item.getPrice()
                        + "," + item.getPreparationTime() + "," + item.getIngredients());
                writer.newLine(); // Add a new line after each item
            }
            System.out.println("Menu items saved to file.");
        } catch (IOException e) {
            System.out.println("Failed to save menu items to file: " + e.getMessage());
        }
    }

    public void checkMenuFileExistence() {
        File file = new File(MENU_FILE_PATH);
        if (file.exists()) {
            System.out.println("menu.txt file exists.");
        } else {
            System.out.println("menu.txt file does not exist.");
        }
    }

    public void loadMenuItemsFromFile() {
//        System.out.println("loadMenuItemsFromFile() called");
        menuItems.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(MENU_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length >= 4) {
                    String name = parts[0].trim();
                    String description = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    double prepTime = Double.parseDouble(parts[3].trim());

                    List<String> ingredients = new ArrayList<>();
                    for (int i = 4; i < parts.length; i++) {
                        ingredients.add(parts[i].trim());
                    }

                    MenuItem item = new MenuItem(name, description, price, prepTime, ingredients);
                    menuItems.add(item);

                    // Print the menu item details for verification
//                    System.out.println("Loaded menu item: " + item);
                } else {
                    System.out.println("Skipped line: " + line);
                }
            }
//            System.out.println("Menu items loaded from file.");
        } catch (IOException e) {
            System.out.println("Failed to load menu items from file: " + e.getMessage());
        }
    }


    public void displayMenu() {
        System.out.println("\nMENU");
//        checkMenuFileExistence();
        loadMenuItemsFromFile();
//        System.out.println(getMenuItems());
        for (MenuItem item : getMenuItems()) {
            System.out.println(item.toString());
            System.out.println("--------------------");
        }
    }

    public MenuItem getMenuItemByName(String itemName) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }
}
