package org.example;

import org.example.model.*;
import org.example.services.*;
import org.example.utilities.GenerateReport;
import org.example.utilities.Role;

import java.util.Scanner;

import static org.example.utilities.Colors.ANSI_RED;


public class Main {

    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

        // Declare service classes for different components of the application
        UserService userService = new UserService();
        MenuService menuService = new MenuService();
        Inventory inventory = new Inventory();
        // Create ingredient objects
        Ingredient potatoes = new Ingredient("potatoes", 200, 100);
        Ingredient oil = new Ingredient("oil", 20, 15);
        Ingredient salt = new Ingredient("salt", 40, 25);
        Ingredient beefPatty = new Ingredient("beef patty", 100, 75);
        Ingredient bun = new Ingredient("bun", 100, 65);
        Ingredient vanillaIceCream = new Ingredient("vanilla ice cream", 80, 60);
        Ingredient milk = new Ingredient("milk", 90, 70);

        // Add ingredients to the inventory
        inventory.addIngredient(potatoes);
        inventory.addIngredient(oil);
        inventory.addIngredient(salt);
        inventory.addIngredient(beefPatty);
        inventory.addIngredient(bun);
        inventory.addIngredient(vanillaIceCream);
        inventory.addIngredient(milk);

        OrderService orderService = new OrderService(inventory);
        TableManager tableManager = new TableManager();
        TableMenuService tableMenuService = new TableMenuService(tableManager, orderService);
        OrderServiceMenu orderServiceMenu = new OrderServiceMenu(orderService, menuService, inventory);
        GenerateReport generateReport = new GenerateReport(orderService);


        InventoryServiceMenu inventoryServiceMenu = new InventoryServiceMenu(orderService.getInventory());

        while (true) {
            // Show the main menu and get the user's choice
            int choice = menuService.showMainMenuAndGetChoice();

            // Check if a user is logged in
            User currentUser = userService.getCurrentUser();

            // Use a switch statement to execute the action corresponding to the user's choice
            switch (choice) {
                case 1 -> userService.loginUser();
                case 2 -> {
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        userService.registerUser(Role.MANAGER);
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 3 -> {
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        userService.registerUser(Role.STAFF);
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 4 -> {
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        menuService.manageMenu();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");;
                    }
                }
                case 5 -> {
                    if (currentUser != null && (currentUser.getRole() == Role.STAFF || currentUser.getRole() == Role.MANAGER)) {
                        orderServiceMenu.showMenu();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 6 -> {
                    if (currentUser != null && (currentUser.getRole() == Role.STAFF || currentUser.getRole() == Role.MANAGER)) {
                        tableMenuService.showMenu();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 7 -> {
                    if (currentUser != null && (currentUser.getRole() == Role.STAFF || currentUser.getRole() == Role.MANAGER)) {
                        inventoryServiceMenu.showMenu();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 8 -> {
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        generateReport.dailyReport();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action.");
                    }
                }
                case 9 -> userService.logoutUser();
                case 0 -> userService.exitApplication();
                default ->
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                        System.out.println(ANSI_RED + "Invalid choice. Please try again.");
            }
        }
    }
}