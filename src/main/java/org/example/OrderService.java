package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private List<Order> orderList;
    private Map<Integer, Order> activeOrders = new HashMap<>();
    private int totalOrders;
    public OrderService() {
        this.orderList = new ArrayList<>();
        this.totalOrders = 0;
    }
    public void addOrder(Order order) {
        orderList.add(order);
        totalOrders = orderList.size();
        activeOrders.put(Integer.valueOf(order.getOrderID()), order);
    }

    public void removeOrder(int orderID) {
        activeOrders.remove(orderID);
    }

    public Order getOrder(int orderID) {
        return activeOrders.get(orderID);
    }
    public String updateStatus(Order.OrderStatus status){
        String foundOrders = "";
        for (Order order: orderList){
            if(order.getOrderStatus() == status){
                foundOrders += order + "\n";
            }
        }
        return foundOrders;
    }
    public int getTotalOrders() {
        return totalOrders;
    }
}