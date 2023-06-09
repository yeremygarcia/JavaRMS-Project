package org.example.services;

import org.example.OrderStatus;
import org.example.model.Order;
import org.example.model.Table;

import java.util.*;

public class OrderService {
    private List<Order> orderList;
    private Map<Integer, Order> activeOrders;
    private int totalOrders;

    public OrderService() {
        this.orderList = new ArrayList<>();
        this.activeOrders = new HashMap<>();
        this.totalOrders = 0;
    }

    public void addOrder(Order order) {
        orderList.add(order);
        activeOrders.put(order.getOrderID(), order);
        totalOrders++;
    }

    public void removeOrder(int orderID) {
        Order order = activeOrders.remove(orderID);
        if (order != null) {
            orderList.remove(order);
            totalOrders--;
        }
    }

    public Order getOrder(int orderID) {
        return activeOrders.get(orderID);
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public List<Order> getOrdersByStatus(OrderStatus status) {
        List<Order> ordersByStatus = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getOrderStatus() == status) {
                ordersByStatus.add(order);
            }
        }
        return ordersByStatus;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void processOrder(int orderID) {
        TableManager tableManager = new TableManager();
        Order order = getOrder(orderID);
        Table table = tableManager.getTableByID(order.getOrderTableID());
        if (order != null && order.getOrderStatus() == OrderStatus.WAITING) {
            // Process the order
            order.updateOrderStatus(OrderStatus.PREPARING);
            System.out.println("Order " + orderID + " has been processed and is ready for payment.");

            // Calculate the total price
            double totalPrice = order.getTotalPrice();

            System.out.println("Total price: $" + totalPrice);

            // Prompt for payment
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter payment amount: $");
            double paymentAmount = scanner.nextDouble();

            // Process the payment
            processPayment(orderID, paymentAmount);
        } else {
            System.out.println("Invalid order ID or the order has already been processed.");
        }
    }


    public void processPayment(int orderID, double amount) {
        Order order = getOrder(orderID);
        if (order != null) {
            double totalPrice = order.getTotalPrice();
            if (amount >= totalPrice) {
                // Payment successful
                double change = amount - totalPrice;
                System.out.println("Payment processed successfully. Change: $" + change);
            } else {
                System.out.println("Insufficient payment amount. Please provide the correct amount.");
            }
        } else {
            System.out.println("Invalid order ID or the order is not yet completed.");
        }
    }

    public double getTotalRevenue() {
        double totalRevenue = 0.0;

        for (Order order : orderList) {
            totalRevenue += order.getTotalPrice();
        }

        return totalRevenue;
    }

}
