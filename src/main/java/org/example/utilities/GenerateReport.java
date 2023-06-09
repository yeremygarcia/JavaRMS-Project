package org.example.utilities;

import org.example.model.Order;
import org.example.services.OrderService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GenerateReport {
    private OrderService orderService;
    private LocalDate currentDate;

    public GenerateReport(OrderService orderService) {
        this.orderService = orderService;
        this.currentDate = LocalDate.now();
    }


    public void dailyReport() {
        // Create a file for the sales report
        String filename = "salesreport.txt";

        try (PrintStream fileStream = new PrintStream(new FileOutputStream(filename))) {
            // Redirect the standard output to the file
            PrintStream originalStream = System.out;
            PrintStream combinedStream = new PrintStream(new CombinedOutputStream(originalStream, fileStream));
            System.setOut(combinedStream);

            System.out.println();
            System.out.println("-----------------------------");
            System.out.println("Daily Sales Report");
            System.out.println("Date: " + currentDate);
            System.out.println("-----------------------------");
            System.out.println("Total Revenue: $" + orderService.getTotalRevenue());
            System.out.println();
            // Calculate item quantities using streams
            Map<String, Integer> itemQuantityMap = orderService.getAllOrders().stream()
                    .flatMap(order -> order.getItemsOrdered().entrySet().stream())
                    .collect(Collectors.groupingBy(entry -> entry.getKey().getName(),
                            Collectors.summingInt(Map.Entry::getValue)));

            // Print the top 3 items with highest quantity
            System.out.println("Most Popular Items:");
            itemQuantityMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .forEach(entry -> System.out.println("- " + entry.getKey() + ": " + entry.getValue()));
            System.out.println();

            // Calculate table costs using streams
            Map<Integer, Double> tableCostMap = orderService.getAllOrders().stream()
                    .collect(Collectors.groupingBy(Order::getOrderTableID, Collectors.summingDouble(Order::getTotalPrice)));

            // Print the top 3 table IDs and their total costs
            System.out.println("Table Sales:");
            tableCostMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .limit(3)
                    .forEach(entry -> System.out.println("- Table ID: " + entry.getKey() + ", Total Cost: $" + entry.getValue()));
            System.out.println();

            // Print all orders
            orderService.getAllOrders().forEach(order -> {
                System.out.println("Order ID: " + order.getOrderID());
                System.out.println("Table ID: " + order.getOrderTableID());
                System.out.println("Items Ordered:");
                order.getItemsOrdered().forEach((item, quantity) -> {
                    double cost = item.getPrice() * quantity;
                    System.out.println("- " + item.getName() + " (Quantity: " + quantity + ", Cost: $" + cost + ")");
                });
                System.out.println("Total Price: $" + order.getTotalPrice());
                System.out.println();
            });

            System.out.println("-----------------------------");

            System.out.println("Sales report exported to " + filename);
            System.out.println();

            // Restore the standard output
            System.setOut(originalStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        // Read user input and perform further actions
    }
}
