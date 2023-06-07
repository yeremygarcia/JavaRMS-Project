package org.example.model;

public class Table {
    private int tableId;
    private int tableSize;
    private TableStatus status;
    private Customer assignedCustomer;

    public Table(int tableId, int tableSize) {
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.status = TableStatus.AVAILABLE;
    }

    // Getters and setters

    public int getTableId() {
        return tableId;
    }

    public int getTableSize() {
        return tableSize;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }

    public Customer getAssignedCustomer() {
        return assignedCustomer;
    }

    public void setAssignedCustomer(Customer assignedCustomer) {
        this.assignedCustomer = assignedCustomer;
    }
}

