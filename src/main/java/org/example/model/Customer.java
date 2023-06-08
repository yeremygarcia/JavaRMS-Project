package org.example.model;

public class Customer {
    private String name;
    private double totalAmountPaid;

    public Customer(String name) {
        this.name = name;
        this.totalAmountPaid = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void payAmount(double amount) {
        totalAmountPaid += amount;
    }
}

