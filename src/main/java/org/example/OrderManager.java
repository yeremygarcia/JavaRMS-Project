package org.example;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    private Map<Integer, Order> activeOrders = new HashMap<>();

    public void addOrder(Order order) {
        activeOrders.put(Integer.valueOf(order.getOrderID()), order);
    }

    public void removeOrder(int orderID) {
        activeOrders.remove(orderID);
    }

    public Order getOrder(int orderID) {
        return activeOrders.get(orderID);
    }
    public void updateStatus(int orderID, OrderStatus status) {
        Order order = activeOrders.get(orderID);
        if (order != null) {
            order.setStatus(status);
        }
    }
}
