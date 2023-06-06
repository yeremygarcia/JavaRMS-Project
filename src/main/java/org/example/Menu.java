package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    public void displayMenu() {
        try {
            File file = new File("menu.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load menu.");
        }
    }
}
