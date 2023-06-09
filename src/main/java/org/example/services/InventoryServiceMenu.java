package org.example.services;

import org.example.model.Ingredient;
import org.example.model.Inventory;

import java.util.Scanner;

public class InventoryServiceMenu {
    private Inventory inventory;
    private Scanner scanner;

    public InventoryServiceMenu(Inventory inventory) {
        this.inventory = inventory;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println();
        System.out.println("==== Inventory Service Menu ====");
        System.out.println("1. Display all ingredients in inventory");
        System.out.println("2. Add more quantities of an ingredient");
        System.out.println("0. Exit");

        int choice = getUserChoice();
        switch (choice) {
            case 1 -> showIngredients();
            case 2 -> addIngredientQuantity();
            case 0 -> System.out.println("Exiting Inventory Service Menu...");
            default -> {
                System.out.println("Invalid choice. Please try again.");
                showMenu();
            }
        }
    }

    private int getUserChoice() {
        System.out.println();
        System.out.print("Enter your choice: ");
        String choiceString = scanner.nextLine();

        int choice;
        try {
            choice = Integer.parseInt(choiceString);
        } catch (NumberFormatException e) {
            choice = -1; // Set an invalid choice if the input is not a valid number
        }

        return choice;
    }


    private void showIngredients() {
        System.out.println();
        System.out.println("==== Ingredients in Inventory ====");
        for (Ingredient ingredient : inventory.getIngredients()) {
            System.out.println(ingredient);
        }
        System.out.println();
        showMenu();
    }

    private void addIngredientQuantity() {
        System.out.println();
        System.out.print("Enter the name of the ingredient to add quantity: ");
        String ingredientName = scanner.nextLine();

        Ingredient ingredient = inventory.getIngredientByName(ingredientName);
        if (ingredient != null) {
            System.out.print("Enter the quantity to add: ");
            int quantityToAdd = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the quantity

            int currentQuantity = ingredient.getQuantity();
            int newQuantity = currentQuantity + quantityToAdd;
            ingredient.setQuantity(newQuantity);

            System.out.println("Quantity of " + ingredientName + " has been updated to " + newQuantity);
        } else {
            System.out.println("Ingredient not found in inventory.");
        }

        System.out.println();
        showMenu();
    }


}

