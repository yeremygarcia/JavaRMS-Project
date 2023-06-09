package org.example.model;

import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Ingredient> ingredients;

    public Inventory() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void checkLowIngredients() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getQuantity() < ingredient.getThreshold()) {
                System.out.println("Alert: " + ingredient.getName() + " is running low!");
            }
        }
    }

    public void updateIngredientUsage(String ingredientName, int quantity) {
        Ingredient ingredient = getIngredientByName(ingredientName);
        if (ingredient != null) {
            int currentQuantity = ingredient.getQuantity();
            int newQuantity = currentQuantity - quantity;
            if (newQuantity >= 0) {
                ingredient.setQuantity(newQuantity);
                System.out.println("Ingredient quantity updated: " + ingredientName + " - Remaining quantity: " + newQuantity);
            } else {
                System.out.println("Insufficient quantity of " + ingredientName + " in inventory.");
            }
        } else {
            System.out.println("Ingredient not found in inventory.");
        }
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public Ingredient getIngredientByName(String ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                System.out.println(ingredient);
                return ingredient;
            }
        }
        return null;
    }

    public boolean areAllIngredientsAvailable(Map<MenuItem, Integer> itemsOrdered) {
        for (Map.Entry<MenuItem, Integer> entry : itemsOrdered.entrySet()) {
            MenuItem item = entry.getKey();
            int quantity = entry.getValue();
            List<String> ingredients = item.getIngredients();

            for (String ingredient : ingredients) {
                if (!isIngredientAvailable(ingredient, quantity)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isIngredientAvailable(String ingredientName, int quantity) {
        Ingredient ingredient = getIngredientByName(ingredientName);
        return ingredient != null && ingredient.getQuantity() >= quantity;
    }
}
