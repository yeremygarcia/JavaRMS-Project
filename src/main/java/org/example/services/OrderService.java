package org.example.services;

import org.example.OrderStatus;
import org.example.model.Order;

import javax.print.DocFlavor;
import java.util.*;

import static org.example.Colors.*;

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
        Order order = getOrder(orderID);
        if (order != null && order.getOrderStatus() == OrderStatus.WAITING) {
            // Process the order
            order.updateOrderStatus(OrderStatus.READY);
            System.out.println(ANSI_PURPLE + "Order " + orderID + " has been processed and is ready for payment." + ANSI_RESET);

            // Calculate the total price
            double totalPrice = order.getTotalPrice();
            System.out.println(ANSI_PURPLE + "Total price: $" + totalPrice + ANSI_RESET);

            // Prompt for payment
            Scanner scanner = new Scanner(System.in);
            System.out.print(ANSI_PURPLE + "Enter payment amount: $" + ANSI_RESET);
            double paymentAmount = scanner.nextDouble();

            // Process the payment
            processPayment(orderID, paymentAmount);
        } else {
            System.out.println(ANSI_RED + "Invalid order ID or the order has already been processed." + ANSI_RESET);
        }
    }


    public void processPayment(int orderID, double amount) {
        Order order = getOrder(orderID);
        if (order != null && order.getOrderStatus() == OrderStatus.READY) {
            double totalPrice = order.getTotalPrice();
            if (amount >= totalPrice) {
                // Payment successful
                double change = amount - totalPrice;
                System.out.println(ANSI_BLUE + "Payment processed successfully. Change: $" + change + ANSI_RESET);
                order.updateOrderStatus(OrderStatus.PAID);
            } else {
                System.out.println(ANSI_RED + "Insufficient payment amount. Please provide the correct amount." + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "Invalid order ID or the order is not yet completed." + ANSI_RESET);
        }
    }
}
