package org.example;
import java.util.Scanner;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static int choice, quantity = 1;
    public static String again;
    public static double total = 0, pay;

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        LoginService loginService = new LoginService(userRepository);

        User user = loginService.login();

        if (user != null) {
            if (user.getRole() == Role.STAFF) {
                System.out.println("Welcome, staff!");
            } else if (user.getRole() == Role.MANAGER) {
                System.out.println("Welcome, manager!");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
        menu();
        order();
    }

    public static void menu() {
        System.out.println("=======================================");
        System.out.println("\t WELCOME TO SAFETECH RESTAURANT        ");
        System.out.println("\t  Restaurant Menu :               ");
        System.out.println("\t  1.Hamburger         USD:2.00");
        System.out.println("\t  2.Cheeseburger    USD:2.00");
        System.out.println("\t  3.Chicken Sandwich         USD:2.00");
        System.out.println("\t  4.Fries      USD:1.50");
        System.out.println("\t  5.Tater Tots      USD:1.50");
        System.out.println("\t  6.Vanilla Shake      USD:1.50");
        System.out.println("\t  7.Choc Shake      USD:1.50");
        System.out.println("\t  8.Cancel                  ");
        System.out.println("=======================================");
    }

    public static void order() {
        System.out.println(
                "Press 1 to order a Hamburger!! Press 2 to order a Cheeseburger!! Press 3 to order a Chicken Sandwich!! Press 4 to order Fries!! Press 5 to order Tater Tots!! Press 6 to order a Vanilla Shake!! Press 7 to order a Choc shake!! Press 8 to cancel.");
        System.out.print("Press you want to Order : ");
        choice = input.nextInt();
        if (choice == 1) {
            System.out.println("You Chose a Hamburger");
            System.out.print("How many Burgers would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println();
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {

                System.out.print("Enter Your Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 2) {
            System.out.println("You Chose Cheeseburger");
            System.out.print("How many Cheeseburgers would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 3) {
            System.out.println("You Chose a Chicken Sandwich");
            System.out.print("How many Chicken Sandwiches would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 4) {
            System.out.println("You Chose Fries");
            System.out.print("How many orders of Fries would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 5) {
            System.out.println("You Chose Tater Tots");
            System.out.print("How many orders of Tater Tots would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 6) {
            System.out.println("You Chose a Vanilla Shake");
            System.out.print("How many Vanilla Shakes would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        }

        else if (choice == 7) {
            System.out.println("You Chose a Choc Shake");
            System.out.print("How many Choc Shakes would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like a add to your order ? ");
            System.out.print("Press Y for [YES] and N for [NO] : ");
            again = input.next();
            if (again.equalsIgnoreCase("Y")) {
                order();
            } else {
                System.out.print("Enter Payment : ");
                pay = input.nextDouble();
                if (pay < total) {

                    System.out.println("Sorry, Insufficient Funds");
                } else {
                    // System.out.println("Total Amount is : " + total);
                    total = pay - total;
                    System.out.println("Customer's Return Amount is : " + total);
                }

            }
        } else if (choice == 8) {
            System.exit(0);
        } else {
            System.out.println("Choose item 1 to 3 only");
            order();
        }
    }
}


