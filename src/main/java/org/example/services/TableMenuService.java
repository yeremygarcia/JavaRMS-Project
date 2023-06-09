package org.example.services;

import java.util.Scanner;

public class TableMenuService {
    private TableManager tableManager;
    private OrderService orderService;
    private Scanner scanner;

    public TableMenuService(TableManager tableManager, OrderService orderService) {
        this.tableManager = tableManager;
        this.orderService = orderService;
        this.scanner = new Scanner(System.in);
    }

    public void displayTableStatuses() {
        System.out.println();
        tableManager.displayTableStatus();
    }

    public void assignTable() {
        System.out.println();
        System.out.println("Enter table ID: ");
        int tableId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter order ID: ");
        int orderId = Integer.parseInt(scanner.nextLine());

        tableManager.assignOrderToTable(tableId, orderService.getOrder(orderId));
    }

    public void unassignTable() {
        System.out.println();
        System.out.println("Enter table ID: ");
        int tableId = Integer.parseInt(scanner.nextLine());

        tableManager.unassignOrderFromTable(tableId);
    }

    public void showMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println("Table Menu:");
            System.out.println("1. Display Table Statuses");
            System.out.println("2. Assign Table");
            System.out.println("3. Unassign Table");
            System.out.println("0. Exit");

            System.out.println();
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> displayTableStatuses();
                case 2 -> assignTable();
                case 3 -> unassignTable();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
