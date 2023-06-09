package org.example.model;

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
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getThreshold() {
        return threshold;
    }
    public boolean isRunningLow() {
        return quantity <= threshold;
    }

    public static void main(String[] args) {
        Ingredient potatoes = new Ingredient("potatoes", 200, 100);
        Ingredient oil = new Ingredient("oil", 20, 15);
        Ingredient salt = new Ingredient("salt", 40, 25);
        Ingredient beefPatty = new Ingredient("beef patty", 100, 75);
        Ingredient bun = new Ingredient("bun", 100, 65);
        Ingredient vanillaIceCream = new Ingredient("vanilla ice cream", 80, 60);
        Ingredient milk = new Ingredient("milk", 90, 70);

        System.out.println(potatoes);
        System.out.println(oil);
        System.out.println(salt);
        System.out.println(beefPatty);
        System.out.println(bun);
        System.out.println(vanillaIceCream);
        System.out.println(milk);
    }
}
