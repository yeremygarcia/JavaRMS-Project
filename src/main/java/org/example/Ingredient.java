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
    public static void main(String[] args) {
        Ingredient bun = new Ingredient("bun", 20, 15);
        Ingredient patty = new Ingredient("patty", 40, 25);
        Ingredient pickle = new Ingredient("pickle", 100, 75);
        Ingredient lettuce = new Ingredient("lettuce", 100, 65);
        Ingredient tomatoes = new Ingredient("tomatoes", 80, 60);
        Ingredient potatoes = new Ingredient("potatoes", 200, 100);
        Ingredient cheese = new Ingredient("cheese", 90, 70);

        System.out.println(bun);
        System.out.println(patty);
        System.out.println(pickle);
        System.out.println(lettuce);
        System.out.println(tomatoes);
        System.out.println(potatoes);
        System.out.println(cheese);
    }
}

