package org.example.services;

import org.example.utilities.OrderStatus;
import org.example.model.Inventory;
import org.example.model.Order;

import org.example.model.MenuItem;

import java.util.Map;
import java.util.Scanner;

public class OrderServiceMenu {
    private OrderService orderService;
    private MenuService menuService;
    private Scanner scanner;
    private Inventory inventory;

    private TableManager tableManager;

    public OrderServiceMenu(OrderService orderService, MenuService menuService, Inventory inventory, TableManager tableManager) {
        this.orderService = orderService;
        this.menuService = menuService;
        this.scanner = new Scanner(System.in);
        this.inventory = inventory;
        this.tableManager = tableManager;
    }

    public void processOrder() {
        System.out.println("Enter table ID: ");
        String tableIdInput = scanner.nextLine();
        int tableId;

        try {
            // Attempt to parse the input string to an integer
            tableId = Integer.parseInt(tableIdInput);
        } catch (NumberFormatException e) {
            // Handle the exception
            System.out.println("Invalid table ID entered. Please enter a valid number.");
            // You can choose to return or continue the program flow here
            return; // or use "continue;" if this is inside a loop
        }

        // Check if the tableId exists in the TableManager
        if (!tableManager.tableExists(tableId)) {
            System.out.println("Table does not exist. Please enter a valid table ID.");
            // You can choose to return or continue the program flow here
            return; // or use "continue;" if this is inside a loop
        }
        // Display the menu
        menuService.displayMenu();

        // Order food
        Order order = new Order(orderService.getTotalOrders() + 1, tableId);
        while (true) {
            System.out.println();
            System.out.println("Enter item name to add to order (0 to finish ordering):");
            String itemName = scanner.nextLine();
            if (itemName.equals("0")) {
                break;
            }

            // Check if the item exists in the menu
            MenuItem item = menuService.getMenuItemByName(itemName);
            if (item == null) {
                System.out.println("Invalid item name.");
                continue;
            }

            System.out.println();
            // Get the quantity
            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            // Add the item to the order
            order.addItem(item, quantity);
            System.out.println("Added " + quantity + "x " + item.getName() + " to the order.");
        }

        // Set the inventory for the OrderService
        orderService.setInventory(inventory);

        // Check for low ingredients
        inventory.checkLowIngredients();

        // Add the order to the order service
        orderService.addOrder(order);

        // Proceed with processing the order only if all ingredients are available
        if (inventory.areAllIngredientsAvailable(order.getItemsOrdered())) {
            // Process the order
            orderService.processOrder(order.getOrderID());

        } else {
            orderService.removeOrder(order.getOrderID());
            System.out.println("Unable to process order. Some ingredients are not available.");
        }
    }

    public void updateOrders() {
        System.out.println();
        System.out.println("Enter order ID: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order order = orderService.getOrder(orderId);
        if (order == null) {
            System.out.println("Invalid order ID.");
            return;
        }

        System.out.println("Enter the new status for the order:");
        String newStatus = scanner.nextLine();

        if (newStatus.equalsIgnoreCase("waiting")) {
            order.setOrderStatus(OrderStatus.WAITING);
        } else if (newStatus.equalsIgnoreCase("ready")) {
            order.setOrderStatus(OrderStatus.READY);
        } else if (newStatus.equalsIgnoreCase("preparing")) {
            order.setOrderStatus(OrderStatus.PREPARING);
        } else {
            System.out.println("Invalid order status. Order status not updated.");
        }

    }


    public void displayAllOrders() {
        System.out.println();
        System.out.println("All Orders:");
        for (Order order : orderService.getAllOrders()) {
            System.out.println("Order ID: " + order.getOrderID() + ", Status: " + order.getOrderStatus());
        }
    }

    public void displaySpecificOrders() {
        System.out.println();
        System.out.println("Enter Order ID: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        Order order = orderService.getOrder(orderId);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        System.out.println();
        System.out.println("Order ID: " + order.getOrderID());
        System.out.println("Table ID: " + order.getOrderTableID());
        System.out.println("Items Ordered:");
        for (Map.Entry<MenuItem, Integer> entry : order.getItemsOrdered().entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            double cost = item.getPrice() * quantity;
            System.out.println("- " + item.getName() + " (Quantity: " + quantity + ", Cost: $" + cost + ")");
        }
        System.out.println("Total Price: " + order.getTotalPrice());
        System.out.println();
    }

    public void showMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("Order Service Menu:");
            System.out.println("1. Process Order");
            System.out.println("2. Update Orders");
            System.out.println("3. Display Specific Orders");
            System.out.println("4. Display All Orders");
            System.out.println("0. Exit");

            System.out.println();
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> processOrder();
                case 2 -> updateOrders();
                case 3 -> displaySpecificOrders();
                case 4 -> displayAllOrders();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}

