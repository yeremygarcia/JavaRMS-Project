package org.example;

import org.example.model.MenuItem;
import org.example.model.Order;
import org.example.model.Table;
import org.example.services.OrderService;
import org.example.services.TableManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesReportService {
    private OrderService orderService;
    private TableManager tableManager;
    private String REPORT_FILE_PATH = "salesReport.txt";

    public SalesReportService(OrderService orderService, TableManager tableManager) {
        this.orderService = orderService;
        this.tableManager = tableManager;
    }

    public String generateDailySalesReport() {
        StringBuilder report = new StringBuilder();

        // Total Revenue
        double totalRevenue = calculateTotalRevenue();
        report.append("Total Revenue: $").append(totalRevenue).append("\n");

        // Most Popular Items
        List<String> popularItems = getMostPopularItems();
        report.append("Most Popular Items: ").append(popularItems).append("\n");

        // Tables With Most Orders
        List<Integer> busyTables = getBusyTables();
        report.append("Tables With Most Orders: ").append(busyTables).append("\n");

        return report.toString();
    }

    public void exportReport() {
        String report = generateDailySalesReport();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REPORT_FILE_PATH))) {
            writer.write(report);
            System.out.println("Sales report exported successfully.");
        } catch (IOException e) {
            System.out.println("Failed to export sales report: " + e.getMessage());
        }
    }

    private double calculateTotalRevenue() {
        return orderService.getAllOrders().stream()
                .filter(order -> order.getOrderStatus() == OrderStatus.PAID)
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    private List<String> getMostPopularItems() {
        Map<String, Long> itemFrequency = new HashMap<>();

        for (Order order : orderService.getAllOrders()) {
            for (MenuItem item : order.getItemsOrdered()) {
                itemFrequency.put(item.getName(), itemFrequency.getOrDefault(item.getName(), 0L) + 1);
            }
        }

        return itemFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Integer> getBusyTables() {
        Map<Integer, Long> tableFrequency = new HashMap<>();

        for (Order order : orderService.getAllOrders()) {
            Table table = Table.getTableId();
            if (table != null) {
                tableFrequency.put(table.getTableId(), tableFrequency.getOrDefault(table.getTableId(), 0L) + 1);
            }
        }

        return tableFrequency.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
