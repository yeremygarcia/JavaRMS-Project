package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
