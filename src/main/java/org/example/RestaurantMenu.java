package org.example;

//Restaurant Management System
import java.util.Scanner;

public class RestaurantMenu {
    public static Scanner input = new Scanner(System.in);
    public static int choice, quantity = 1;
    public static String again;
    public static double total = 0, pay;

    public static void menu() {
        System.out.println("=======================================");
        System.out.println("\t WELCOME TO SAFETECH RESTAURANT        ");
        System.out.println("\t  Restaurant Menu :               ");
        System.out.println("\t  1.Burger         USD:9.00");
        System.out.println("\t  2.Whole Pizza    USD:25.00");
        System.out.println("\t  3.Coffee         USD:3.00");
        System.out.println("\t  4.Cancel                  ");
        System.out.println("=======================================");
    }

    public static void order() {
        System.out.println(
                "Press 1 to order Burger!! Press 2 to order Pizza!! Press 3 to order Coffee!! Press 4 to cancel");
        System.out.print("Press you want to Order : ");
        choice = input.nextInt();
        if (choice == 1) {
            System.out.println("You Choice Burger");
            System.out.print("How many Burger you to want to order : ");
            quantity = input.nextInt();
            total = total + (quantity * 9);
            System.out.println("Total Amount is : " + total);
            System.out.println();
            System.out.println("You want to buy again ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {

                System.out.print("Enter Your Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Not Enough Payment");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        } else if (choice == 2) {
            System.out.println("You Choice Whole Pizza");
            System.out.print("How many Whole Pizza you to want to order : ");
            quantity = input.nextInt();
            total = total + (quantity * 25);
            System.out.println("Total Amount is : " + total);
            System.out.println("You want to buy again ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Not Enough Payment");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        } else if (choice == 3) {
            System.out.println("You Choice Coffee");
            System.out.print("How many Cup of Coffee you to want to order : ");
            quantity = input.nextInt();
            total = total + (quantity * 3);
            System.out.println("Total Amount is : " + total);
            System.out.println("You want to buy again ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Not Enough Payment");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        } else if (choice == 4) {
            System.exit(0);
        } else {
            System.out.println("Choose item 1 to 3 only");
            order();
        }
    }
}
