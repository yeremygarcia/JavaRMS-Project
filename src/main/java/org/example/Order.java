package org.example;

import java.text.SimpleDateFormat;
import java.util.*;

public class Order {
    private double totalPrice;
    private OrderStatus orderStatus;
    private HashMap<String, Integer> quantityOrdered;
    private List<MenuItem> itemsOrdered;
    private final Date lastHandled;
    private int orderID;
    private int orderTableID;
    enum OrderStatus {
        WAITING,
        PREPARING,
        READY
    }

    public Order() {
        this.totalPrice = 0;
        this.orderID = Integer.parseInt(String.valueOf(0));
        //this.orderStatus = OrderStatus.WAITING;
        this.itemsOrdered = new ArrayList<>();
        this.quantityOrdered = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.lastHandled = new Date();
        formatter.format(lastHandled);
        this.orderTableID = 0;
    }

    private void calculateTotalPrice() {
        setTotalPrice();
        double price = 0.0;
        for (MenuItem itemName : itemsOrdered) {
            int quantity = getQuantity(itemName);
            double itemPrice = getItemPrice(String.valueOf(itemName));
            price += itemPrice * quantity;
        }
        this.totalPrice = price;
    }

    private int getQuantity(MenuItem itemName) {
        return 0;
    }

    public void addItemsOrdered(MenuItem item) {
        totalPrice = 0;
        itemsOrdered.add(item);
        getTotalPrice();
    }

    private void setTotalPrice() {
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

    public int getOrderID() {
        return orderID;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public double getTotalPrice() {
        setTotalPrice();
        return totalPrice;
    }

    public Map<String, Integer> getItemsOrdered() {
        return (Map<String, Integer>) itemsOrdered;
    }
    public String getOrderedItems(){
        List<MenuItem> itemsOrdered = getItemsOrderedList();
        String orderList = "";
        for(MenuItem item: itemsOrdered){
            orderList += item + "\n";
        }
        return orderList;
    }

    private List<MenuItem> getItemsOrderedList() {
        return itemsOrdered;
    }
    public String addItemQuantity(){
        String orderInfo = "\n";
        quantityOrdered.clear();
        for(MenuItem item: itemsOrdered){
            if(!quantityOrdered.containsKey(item.getName())){
                quantityOrdered.put(item.getName(),1);
            } else {
                quantityOrdered.put(item.getName(), quantityOrdered.get(item.getName()) + 1);
            }
        }
        for(MenuItem item: itemsOrdered){
            if(!orderInfo.contains(item.getName())){
                orderInfo += item.getName() + "->" + quantityOrdered.get(item.getName()) + "\n";
            }
        }
        return orderInfo;
    }

    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", itemsOrdered=" + itemsOrdered +
                ", totalPrice=" + totalPrice +
                ", status=" + orderStatus +
                '}';
    }
}