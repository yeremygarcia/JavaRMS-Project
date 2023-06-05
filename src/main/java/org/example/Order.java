package org.example;

import java.util.Map;

public class Order {
    private static int nextOrderId = 1;
    private int orderID;
    private Map<String, Integer> itemsOrdered;
    private double totalPrice;
    private OrderStatus status;

    public Order(Map<String, Integer> itemsOrdered) {
        this.orderID = nextOrderId++;
        this.itemsOrdered = itemsOrdered;
        calculateTotalPrice();
        this.status = OrderStatus.WAITING;
    }
    private void calculateTotalPrice() {
        double price = 0.0;
        for (Map.Entry<String, Integer> entry : itemsOrdered.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            double itemPrice = getItemPrice(itemName);
            price += itemPrice * quantity;
        }
        this.totalPrice = price;
    }
    private double getItemPrice(String itemName) {

        if (itemName.equals("Cheeseburger")) {
            return 2.0;
        } else if (itemName.equals("Fries")) {
            return 1.0;
        } else if (itemName.equals("Strawberry Shake")) {
            return 1.50;
        }
        return 0.0;
    }
    public Integer getOrderID() {
        return orderID;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public String toString() {
        return "Order{" +
                "orderId=" + orderID  +
                ", itemsOrdered=" + itemsOrdered +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }

    // Getters, Setters, etc.
}