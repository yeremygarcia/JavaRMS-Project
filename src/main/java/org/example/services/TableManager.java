package org.example.services;

import org.example.model.Customer;
import org.example.TableStatus;
import org.example.model.Table;

import java.util.HashMap;
import java.util.Map;

import static org.example.Colors.*;

public class TableManager {
    private Map<Integer, Table> tables;

    public TableManager() {
        tables = new HashMap<>();
        // Initialize tables
        tables.put(1, new Table(1, 4));
        tables.put(2, new Table(2, 2));
        tables.put(3, new Table(3, 6));
    }

    public void assignCustomerToTable(int tableId, Customer customer) {
        Table table = tables.get(tableId);
        if (table != null && table.getStatus() == TableStatus.AVAILABLE) {
            table.setStatus(TableStatus.OCCUPIED);
            table.setAssignedCustomer(String.valueOf(customer));
            System.out.println("Assigned customer " + customer.getName() + " to table " + tableId);
        } else {
            System.out.println("Table " + tableId + " is not available for assignment.");
        }
    }
    public void reserveTable(int tableId, Customer customer) {
        Table table = tables.get(tableId);
        if (table != null && table.getStatus() == TableStatus.AVAILABLE) {
            table.setStatus(TableStatus.RESERVED);
            table.setAssignedCustomer(String.valueOf(customer));
            System.out.println(ANSI_YELLOW + "Table " + tableId + " has been reserved for " + customer.getName() + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "Table " + tableId + " is not available for reservation." + ANSI_RESET);
        }
    }
    public void displayTableStatus() {
        for (Map.Entry<Integer, Table> entry : tables.entrySet()) {
            int tableId = entry.getKey();
            Table table = entry.getValue();
            TableStatus status = table.getStatus();
            String customerName = (table.getAssignedCustomer() != null) ? table.getAssignedCustomer().getName() : "None";

            System.out.println("Table " + tableId + ", Status: " + status + ", Assigned Customer: " + customerName);
        }
    }

    public Table getTableByID(int tableID) {
        return tables.get(tableID);
    }
}
