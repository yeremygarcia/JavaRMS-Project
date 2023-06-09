package org.example.model;

import org.example.TableStatus;

public class Table {
    private int tableId;
    private int tableSize;
    private TableStatus status;
    private Order order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

