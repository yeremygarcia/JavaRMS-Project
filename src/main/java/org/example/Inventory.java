package org.example;

import org.example.Ingredient;

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

    public void updateIngredientQuantity(String ingredientName, int usedQuantity) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName)) {
                int currentQuantity = ingredient.getQuantity();
                ingredient.setQuantity(currentQuantity - usedQuantity);

                if (currentQuantity - usedQuantity <= ingredient.getThreshold()) {
                    System.out.println("Alert: " + ingredient.getName() + " is running low!");
                }
                break;
            }
        }
    }
    public void checkLowIngredients() {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.isRunningLow()) {
                System.out.println("Alert: " + ingredient.getName() + " is running low!");
            }
        }
    }
    public void updateIngredientUsage(String ingredientName, int usedQuantity) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName)) {
                int currentQuantity = ingredient.getQuantity();
                ingredient.setQuantity(currentQuantity - usedQuantity);
                checkLowIngredients();
                break;
            }
        }
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }



}

