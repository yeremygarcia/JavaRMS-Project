package org.example;

import java.util.List;
import java.util.Map;

public class Order {
    private String orderID;
    private Map<String, Integer> itemsOrdered;
    private double totalPrice;
    private OrderStatus status;

    public Order(String orderID, Map<String, Integer> itemsOrdered, OrderStatus status) {
        this.orderID = orderID;
        this.itemsOrdered = itemsOrdered;
        this.status = status;
        calculateTotalPrice();
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

    public String getOrderID() {
        return orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<String, Integer> getItemsOrdered() {
        return itemsOrdered;
    }

    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", itemsOrdered=" + itemsOrdered +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                '}';
    }
}
