package org.example;

import org.example.model.*;
import org.example.services.MenuService;
import org.example.services.OrderService;
import org.example.services.UserService;
import org.example.services.TableManager;


import java.util.Scanner;

import static org.example.Colors.*;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Declare service classes for different components of the application
        UserService userService = new UserService();
//        InventoryService inventoryService = new InventoryService();
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
        TableManager tableManager = new TableManager();


//        SalesService salesService = new SalesService();

//        menuService.loadMenuItemsFromFile();

        while (true) {
            // Show the main menu and get the user's choice
            int choice = menuService.showMainMenuAndGetChoice();

            // Check if a user is logged in
            User currentUser = userService.getCurrentUser();

            // Use a switch statement to execute the action corresponding to the user's choice
            switch (choice) {
                case 1:
                    userService.loginUser();
                    break;

                case 2:
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        userService.registerUser(Role.MANAGER);
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action." + ANSI_RESET);
                    }
                    break;

                case 3:
                    userService.registerUser(Role.STAFF);
                    break;

                case 4:
                    if (currentUser != null && currentUser.getRole() == Role.MANAGER) {
                        menuService.manageMenu();
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action." + ANSI_RESET);
                    }
                    break;

                case 5:
                    if (currentUser != null && currentUser.getRole() == Role.STAFF) {
                        // Get the customer's name
                        System.out.print(ANSI_CYAN + "Enter customer name: " + ANSI_RESET);
                        String customerName = scanner.nextLine();
                        Customer customer = new Customer(customerName);

                        // Display the menu
                        menuService.displayMenu();

                        // Order food
                        Order order = new Order(orderService.getTotalOrders() + 1);
                        while (true) {
                            System.out.println(ANSI_PURPLE + "Enter item name to add to order (0 to finish ordering):" + ANSI_RESET);
                            String itemName = scanner.nextLine();
                            if (itemName.equals("0")) {
                                break;
                            }

                            // Check if the item exists in the menu
                            MenuItem item = menuService.getMenuItemByName(itemName);
                            if (item == null) {
                                System.out.println(ANSI_RED + "Invalid item name." + ANSI_RESET);
                                continue;
                            }

                            // Get the quantity
                            System.out.print(ANSI_YELLOW + "Enter quantity: " + ANSI_RESET);
                            int quantity = Integer.parseInt(scanner.nextLine());

                            // Add the item to the order
                            order.addItem(item, quantity);
                            System.out.println(ANSI_CYAN + "Added " + quantity + "x " + item.getName() + " to the order." + ANSI_RESET);
                        }

                        // Add the order to the order service
                        orderService.addOrder(order);

                        // Process the order
                        orderService.processOrder(order.getOrderID());
                    } else {
                        System.out.println(ANSI_RED + "You don't have permission to perform this action." + ANSI_RESET);
                    }
                    break;

                case 6:
                    tableManager.displayTableStatus();
                    System.out.println("Enter table ID: ");
                    int tableId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    Customer customer = new Customer(customerName);

                    tableManager.assignCustomerToTable(tableId, customer);
                    tableManager.displayTableStatus();
                    break;
                case 7:
                    System.out.print(ANSI_CYAN + "Enter the table ID to reserve: ");
                    int tableIdToReserve = Integer.parseInt(scanner.nextLine());
                    System.out.print("Customer name for reservation: " + ANSI_RESET);
                    String reserveName = scanner.nextLine();
                    Customer customerReserved = new Customer(reserveName);

                    tableManager.reserveTable(tableIdToReserve, customerReserved);
                    tableManager.displayTableStatus();

                    break;

                // case 7: Manage the inventory
                // Here, you would call appropriate methods from the InventoryService to manage the inventory

                // case 8: Generate a sales report
                // Here, you would call a method from the SalesService to generate a sales report

                case 9:
                    userService.logoutUser();
                    break;

                case 0:
                    userService.exitApplication();
                    break;


                default:
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}