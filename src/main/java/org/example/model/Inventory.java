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
        String trimmedName = ingredientName.replace("[", "").replace("]", "");
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(trimmedName)) {
//                System.out.println(trimmedName);
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

            List<String> cleanedIngredients = new ArrayList<>();
            for (String ingredient : ingredients) {
                String cleanedIngredient = ingredient.replaceAll("\\[|\\]", "");
                cleanedIngredients.add(cleanedIngredient);
            }

            for (String ingredient : cleanedIngredients) {
                if (!isIngredientAvailable(ingredient, quantity)) {
                    System.out.println(ingredient);
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isIngredientAvailable(String ingredientName, int quantity) {
        String trimmedName = ingredientName.replace("[", "").replace("]", "");
        Ingredient ingredient = getIngredientByName(trimmedName);
        return ingredient != null && ingredient.getQuantity() >= quantity;
    }

    public boolean doesIngredientExist(String ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                return true;
            }
        }
        return false;
    }
}
