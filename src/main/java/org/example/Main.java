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

                // case 0: Exit the application
                // Here, you would exit the while loop and therefore end the application

                default:
                    // Handle an invalid choice
                    // Here, you could show an error message and loop back to show the menu again
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
<<<<<<< HEAD
        List<MenuItem> menu = loadMenu("C:\\Users\\admin\\Desktop\\JAVAProject-103\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");

        // Example usage
        MenuItem item1 = new MenuItem("Item 1", "Description 1", 10.0, 9.99, new ArrayList<>());
        MenuItem item2 = new MenuItem("Item 2", "Description 2", 15.0, 14.99, new ArrayList<>());
        MenuItem item3 = new MenuItem("Item 3", "Description 3", 15.0, 14.99, new ArrayList<>());
        MenuItem item4 = new MenuItem("Item 4", "Description 4", 15.0, 14.99, new ArrayList<>());
        MenuItem item5 = new MenuItem("Item 5", "Description 5", 15.0, 14.99, new ArrayList<>());
        MenuItem item6 = new MenuItem("Item 6", "Description 6", 15.0, 14.99, new ArrayList<>());
        MenuItem item7 = new MenuItem("Item 7", "Description 7", 15.0, 14.99, new ArrayList<>());


        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        menu.add(item7);

        saveMenu(menu, "C:\\Users\\admin\\Desktop\\JAVAProject-103\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");
=======
>>>>>>> e2e8db43902a61d77fedaee8397bb95d1bb0eba4
    }
}