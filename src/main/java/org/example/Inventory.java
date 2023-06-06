package org.example;

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
}
