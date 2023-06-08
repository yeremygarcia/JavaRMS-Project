package org.example.model;

import org.example.TableStatus;

public class Table {
    public Table customer;
    private int tableId;
    private int tableSize;
    private TableStatus status;
    private String assignedCustomer;

    public Table(int tableId, int tableSize) {
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.status = TableStatus.AVAILABLE;
    }

    public Table() {

    }
<<<<<<< HEAD

    // Getters and setters
=======
>>>>>>> e891c6bbc0ec234a65567a66d89bf807955991f7

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

    public String getAssignedCustomer() {
        return assignedCustomer;
    }

    public void setAssignedCustomer(String assignedCustomer) {
        this.assignedCustomer = assignedCustomer;
    }
}

