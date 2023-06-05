package org.example;

import java.util.Map;

public class Order {
    private int orderID;
    private Map<MenuItem, Integer> itemsOrdered;
    private double totalPrice;
    private OrderStatus status;

    public Order(int orderID, Map<MenuItem, Integer> itemsOrdered, double totalPrice, OrderStatus status) {
        this.orderID = orderID;
        this.itemsOrdered = itemsOrdered;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getOrderID() {
        return getOrderID();
    }

    public void setStatus(OrderStatus status) {
    }

    // Getters, Setters, etc.
}