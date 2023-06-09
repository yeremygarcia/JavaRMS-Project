package org.example.model;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItem {
    private String itemName;
    private String itemDescription;
    private double preparationTime;
    private double itemPrice;
    private List<String> ingredients;
    private int amountOfTimesOrdered;

    public MenuItem(String itemName, String itemDescription, double preparationTime, double itemPrice, List<String> ingredients) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.preparationTime = preparationTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return itemName;
    }

    public String getDescription() {
        return itemDescription;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public double getPrice() {
        return itemPrice;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getAmountOfTimesOrdered() {
        return amountOfTimesOrdered;
    }

    public void setAmountOfTimesOrdered(int amountOfTimesOrdered) {
        this.amountOfTimesOrdered = amountOfTimesOrdered;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append("\n");
        sb.append("Description: ").append(getDescription()).append("\n");
        sb.append("Price: $").append(getPrice()).append("\n");
        sb.append("Prep Time: ").append(getPreparationTime()).append(" minutes").append("\n");
        sb.append("Ingredients: ");

        if (!getIngredients().isEmpty()) {
            sb.append(getIngredients().get(0));

            for (int i = 1; i < getIngredients().size(); i++) {
                sb.append(", ").append(getIngredients().get(i));
            }
        }

        return sb.toString();
    }

}