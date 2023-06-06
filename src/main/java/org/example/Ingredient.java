package org.example;

public class Ingredient {
    private String name;
    private int quantity;
    private int threshold;

    public Ingredient(String name, int quantity, int threshold) {
        this.name = name;
        this.quantity = quantity;
        this.threshold = threshold;
    }
    @Override
    public String toString() {
        return "Ingredient: " + name + ", Quantity: " + quantity;
    }

    public String getName() {
        return getName();
    }

    public int getQuantity() {
        return getQuantity();
    }

    public void setQuantity(int i) {
    }

    public int getThreshold() {
        return 0;
    }
}
