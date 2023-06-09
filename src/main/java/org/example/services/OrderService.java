package org.example.services;

import org.example.utilities.OrderStatus;
import org.example.model.*;

import java.lang.reflect.Array;
import java.util.*;

public class OrderService {
    private List<Order> orderList;
    private Map<Integer, Order> activeOrders;
    private int totalOrders;
    private Inventory inventory;

    public OrderService(Inventory inventory) {
        this.orderList = new ArrayList<>();
        this.activeOrders = new HashMap<>();
        this.inventory = inventory;

        MenuItem burger = new MenuItem("burger", "award winning burger", 8, 6, Arrays.asList("burger patty", "bun"));
        MenuItem fries = new MenuItem("fries", "crinkle cut", 2,2, Arrays.asList("potatoes", "oil", "salt"));
        MenuItem vanillaShake = new MenuItem("vanilla shake", "tasty vanilla milkshake", 3,2, Arrays.asList("vanilla ice cream", "milk"));
        MenuItem cs = new MenuItem("chicken sandwich", "classic chicken sandwich",8,5, Arrays.asList("chicken patty", "bun"));

        Order order1 = new Order(1,2);
        order1.addItem(burger, 2);
        order1.addItem(fries, 2);
        order1.addItem(vanillaShake, 2);
        order1.setOrderStatus(OrderStatus.PREPARING);

        Order order2 = new Order(2,2);
        order2.addItem(cs, 1);
        order2.addItem(fries, 1);
        order2.setOrderStatus(OrderStatus.PREPARING);

        Order order3 = new Order(3, 3);
        order3.addItem(vanillaShake, 5);
        order3.setOrderStatus(OrderStatus.PREPARING);

        Order order4 = new Order(4,1);
        order4.addItem(fries, 3);
        order4.addItem(cs, 3);
        order4.setOrderStatus(OrderStatus.PREPARING);

        Order order5 = new Order(5, 1);
        order5.addItem(burger,1);
        order5.setOrderStatus(OrderStatus.PREPARING);

        this.orderList.add(order1);
        this.orderList.add(order2);
        this.orderList.add(order3);
        this.orderList.add(order4);
        this.orderList.add(order5);

        this.activeOrders.put(order1.getOrderID(), order1);
        this.activeOrders.put(order2.getOrderID(), order2);
        this.activeOrders.put(order3.getOrderID(), order3);
        this.activeOrders.put(order4.getOrderID(), order4);
        this.activeOrders.put(order5.getOrderID(), order5);

        this.totalOrders = 5;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
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
        Order order = activeOrders.get(orderID);
        if (order != null) {
            return order;
        } else {
            System.out.println("Order not found with ID: " + orderID);
            return null;
        }
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
        System.out.println("Order ID: " + orderID);
        Order order = getOrder(orderID);
        Table table = tableManager.getTableByID(order.getOrderTableID());
        if (order != null && order.getOrderStatus() == OrderStatus.WAITING) {
            // Process the order
            order.updateOrderStatus(OrderStatus.PREPARING);
            System.out.println("Order " + orderID + " has been processed and is ready for payment.");
            System.out.println();

            // Update ingredient usage
            for (Map.Entry<MenuItem, Integer> entry : order.getItemsOrdered().entrySet()) {
                MenuItem item = entry.getKey();
                int quantity = entry.getValue();

                // Update the ingredient usage
                for (String ingredientName : item.getIngredients()) {
                    String trimmedName = ingredientName.replace("[", "").replace("]", "");
                    inventory.updateIngredientUsage(trimmedName, quantity);
                }
            }

            // Calculate the total price
            double totalPrice = order.getTotalPrice();

            System.out.println();
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
                System.out.println();
            } else {
                System.out.println("Insufficient payment amount. Please provide the correct amount.");
                System.out.println();
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
