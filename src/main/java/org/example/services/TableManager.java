package org.example.services;

import org.example.utilities.TableStatus;
import org.example.model.Order;
import org.example.model.Table;

import java.util.*;

public class TableManager {
    private Map<Integer, Table> tables;

    public TableManager() {
        tables = new HashMap<>();
        // Initialize tables
        tables.put(1, new Table(1, 4));
        tables.put(2, new Table(2, 2));
        tables.put(3, new Table(3, 6));
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public void assignOrderToTable(int tableId, Order order) {
        Table table = tables.get(tableId);
        if (table != null && table.getStatus() == TableStatus.AVAILABLE) {
            table.setStatus(TableStatus.OCCUPIED);
            table.setOrder(order);
            System.out.println("Assigned order number " + order.getOrderID() + " to table " + tableId);
        } else {
            System.out.println("Table " + tableId + " is not available for assignment.");
        }
    }

    public void unassignOrderFromTable(int tableNumber) {
        Table table = getTableByID(tableNumber);
        if (table != null) {
            table.setOrder(null);
            table.setStatus(TableStatus.AVAILABLE);
            System.out.println("Order unassigned from table " + tableNumber);
        } else {
            System.out.println("Table " + tableNumber + " not found");
        }
    }

    public void displayTableStatus() {
        for (Map.Entry<Integer, Table> entry : tables.entrySet()) {
            int tableId = entry.getKey();
            Table table = entry.getValue();
            TableStatus status = table.getStatus();
            String orderId = (table.getOrder() != null) ? Integer.toString(table.getOrder().getOrderID()) : "None";

            System.out.println("Table " + tableId + ", Status: " + status + ", Assigned OrderId: " + orderId);
        }
    }

    public Table getTableByID(int tableID) {
        return tables.get(tableID);
    }

    public boolean tableExists(int tableId) {
        return getTableByID(tableId) != null;
    }
}

