package org.example;


import org.example.model.Table;
import org.example.services.MenuService;
import org.example.services.UserService;
import org.example.services.TableManager;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
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
        Table table = new Table();


//        SalesService salesService = new SalesService();

        while (true) {
            // Show the main menu and get the user's choice
            int choice = menuService.showMainMenuAndGetChoice();

            // Use a switch statement to execute the action corresponding to the user's choice
            switch (choice) {
                case 1:
                    userService.loginUser();
                    break;

                case 2:
                    userService.registerUser(Role.MANAGER);
                    break;

                case 3:
                    userService.registerUser(Role.STAFF);
                    break;

                case 4:
                    menuService.manageMenu();
                    break;

                // case 5: Process orders from customers
                // Here, you would call appropriate methods from the OrderService to handle orders

                case 6:
                    System.out.println("Enter table ID: ");
                    int tableId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName);

                    tableManager.assignCustomerToTable(tableId, customer);

                    tableManager.displayTableStatus();
                    break;


                // case 7: Manage the inventory
                // Here, you would call appropriate methods from the InventoryService to manage the inventory

                // case 8: Generate a sales report
                // Here, you would call a method from the SalesService to generate a sales report

                // case 9: Log out the current user
                // Here, you would call a method from the UserService to handle user logout

                // case 0: Exit the application
                // Here, you would exit the while loop and therefore end the application

                default:
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}