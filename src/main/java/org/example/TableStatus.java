package org.example;

import org.example.model.Customer;
import org.example.model.MenuItem;

public enum TableStatus {
    AVAILABLE,
    RESERVED,
    OCCUPIED;

    public Customer getAssignedCustomer() {
        return null;
    }
}

