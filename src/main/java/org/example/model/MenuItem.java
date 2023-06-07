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

    public MenuItem(String itemName, String itemDescription, double preparationTime, double itemPrice, List<String> ingredients) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.preparationTime = preparationTime;
        this.itemPrice = itemPrice;
        this.ingredients = ingredients;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getPreparationTime() {
        return preparationTime;
    }

    public double getItemPrice() {
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

    @Override
    public String toString() {
        return "Name: " + getItemName() +
                "\nDescription: " + getItemDescription() +
                "\nPrice: $" + getItemPrice() +
                "\nPrep Time: " + getPreparationTime() + " minutes" +
                "\nIngredients: " + getIngredients();
    }
}