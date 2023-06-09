package org.example;

import org.example.model.*;
import org.example.services.*;
import org.example.utilities.GenerateReport;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

        // Declare service classes for different components of the application
        UserService userService = new UserService();
//        InventoryService inventoryService = new InventoryService();
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        TableManager tableManager = new TableManager();
        TableMenuService tableMenuService = new TableMenuService(tableManager, orderService);
        OrderServiceMenu orderServiceMenu = new OrderServiceMenu(orderService, menuService);
        GenerateReport generateReport = new GenerateReport(orderService);

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
                        System.out.println("You don't have permission to perform this action.");
                    }
                }
                case 3 -> userService.registerUser(Role.STAFF);
                case 4 -> {
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        menuService.manageMenu();
                    } else {
                        System.out.println("You don't have permission to perform this action.");
                    }
                }
                case 5 -> {
                    if (currentUser != null && currentUser.getRole() == Role.STAFF) {
                        orderServiceMenu.showMenu();
                    } else {
                        System.out.println("You don't have permission to perform this action.");
                    }
                }
                case 6 -> tableMenuService.showMenu();


                // case 7: Manage the inventory
                // Here, you would call appropriate methods from the InventoryService to manage the inventory

                case 8 -> generateReport.dailyReport();

                case 9 -> userService.logoutUser();
                case 0 -> userService.exitApplication();
                default ->
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                        System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}