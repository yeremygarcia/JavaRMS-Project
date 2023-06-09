package org.example.model;

import org.example.utilities.OrderStatus;

import java.util.*;

public class Order {
    private int orderID;
    private int orderTableId;
    private double totalPrice;
    private OrderStatus orderStatus;
    private Map<MenuItem, Integer> itemsOrdered;
    private Date lastHandled;


    public Order(int orderID, int orderTableId) {
        this.orderID = orderID;
        this.orderTableId = orderTableId;
        this.totalPrice = 0.0;
        this.orderStatus = OrderStatus.WAITING;
        this.itemsOrdered = new HashMap<>();
        this.lastHandled = new Date();
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderTableID() {
        return orderTableId;
    }


    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Map<MenuItem, Integer> getItemsOrdered() {
        return itemsOrdered;
    }

    public Date getLastHandled() {
        return lastHandled;
    }

    public void addItem(MenuItem item, int quantity) {
        itemsOrdered.put(item, quantity);
        calculateTotalPrice();
    }

    public void removeItem(MenuItem item) {
        itemsOrdered.remove(item);
        calculateTotalPrice();
    }

    public void updateOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    private void calculateTotalPrice() {
        double price = 0.0;
        for (Map.Entry<MenuItem, Integer> entry : itemsOrdered.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            price += item.getPrice() * quantity;
        }
        this.totalPrice = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", totalPrice=" + totalPrice +
                ", orderStatus=" + orderStatus +
                ", itemsOrdered=" + itemsOrdered +
                ", lastHandled=" + lastHandled +
                '}';
    }
}
