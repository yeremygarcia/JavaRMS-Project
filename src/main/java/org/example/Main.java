package org.example;


import org.example.services.MenuService;
import org.example.services.UserService;

public class Main {

    public static void main(String[] args) {
        // Declare service classes for different components of the application
        UserService userService = new UserService();
//        InventoryService inventoryService = new InventoryService();
        MenuService menuService = new MenuService();
        OrderService orderService = new OrderService();
//        SalesService salesService = new SalesService();

//        menuService.loadMenuItemsFromFile();

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

                // case 6: Manage tables in the restaurant
                // Here, you would call appropriate methods to manage tables

                // case 7: Manage the inventory
                // Here, you would call appropriate methods from the InventoryService to manage the inventory

                // case 8: Generate a sales report
                // Here, you would call a method from the SalesService to generate a sales report

                // case 9: Log out the current user
                // Here, you would call a method from the UserService to handle user logout

                case 0:
                    return;


                default:
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}