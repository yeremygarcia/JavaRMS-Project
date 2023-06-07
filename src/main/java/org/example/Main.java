package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.example.MenuItem.loadMenu;
import static org.example.MenuItem.saveMenu;
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static int choice, quantity = 1;
    public static String again;
    public static double total = 0, pay;
    private static Scanner scanner;

    private static void editItem(List<MenuItem> menu, Scanner scanner) {
    }

    private static void removeItem(List<MenuItem> menu, Scanner scanner) {
    }

    private static void addItem(List<MenuItem> menu, Scanner scanner) {
    }

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
        System.out.println("\t  FOOD & DRINK MENU :               ");
        System.out.println();
        System.out.println("\t  1.Hamburger         USD:2.00");
        System.out.println("\t  2.Cheeseburger      USD:2.00");
        System.out.println("\t  3.Chicken Sandwich  USD:2.00");
        System.out.println("\t  4.Fries             USD:1.50");
        System.out.println("\t  5.Tater Tots        USD:1.50");
        System.out.println("\t  6.Vanilla Shake     USD:1.50");
        System.out.println("\t  7.Chocolate Shake   USD:1.50");
        System.out.println("\t  8.Cancel                  ");
        System.out.println("=======================================");
    }

    public static void order() {
        System.out.println(
                "Press 1 to order a Hamburger!! Press 2 to order a Cheeseburger!! Press 3 to order a Chicken Sandwich!! Press 4 to order Fries!! Press 5 to order Tater Tots!! Press 6 to order a Vanilla Shake!! Press 7 to order a Chocolate shake!! Press 8 to cancel.");
        System.out.print(" ADD ITEM # : ");
        choice = input.nextInt();
        if (choice == 1) {
            System.out.println("You selected a Hamburger");
            System.out.print("How many Burgers would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println();
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 2) {
            System.out.println("You selected a Cheeseburger");
            System.out.print("How many Cheeseburgers would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 3) {
            System.out.println("You selected Chicken Sandwich");
            System.out.print("How many Chicken Sandwiches would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 2);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 4) {
            System.out.println("You selected Fries");
            System.out.print("How many order of Fries would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 5) {
            System.out.println("You selected Tater Tots");
            System.out.print("How many orders of Tater Tots would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 6) {
            System.out.println("You selected Vanilla Shake");
            System.out.print("How many Vanilla Shakes would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
        } else if (choice == 7) {
            System.out.println("You selected Chocolate Shake");
            System.out.print("How many Chocolate Shake would you like ? : ");
            quantity = input.nextInt();
            total = total + (quantity * 1.50);
            System.out.println("Total Amount is : " + total);
            System.out.println("Would you like to add more items? ");
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
            System.out.println("Invalid choice, please choose item 1 to 8 only");
            System.out.println();
            order();

            String statusString = scanner.nextLine();
            OrderService orderService = new OrderService();
            if (statusString.equalsIgnoreCase("ready")) {
                System.out.println(orderService.updateStatus(Order.OrderStatus.READY));
            } else if (statusString.equalsIgnoreCase("waiting")) {
                System.out.println(orderService.updateStatus(Order.OrderStatus.WAITING));
            } else if (statusString.equalsIgnoreCase("preparing")) {
                System.out.println(orderService.updateStatus(Order.OrderStatus.PREPARING));
            }
        }
        List<MenuItem> menu = loadMenu("C:\\Users\\admin\\Documents\\CTAC-Program\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");

        // Example usage
        MenuItem item1 = new MenuItem("Item 1", "Description 1", 10.0, 9.99, new ArrayList<>());
        MenuItem item2 = new MenuItem("Item 2", "Description 2", 15.0, 14.99, new ArrayList<>());
        MenuItem item3 = new MenuItem("Item 3", "Description 3", 15.0, 14.99, new ArrayList<>());
        MenuItem item4 = new MenuItem("Item 4", "Description 4", 15.0, 14.99, new ArrayList<>());
        MenuItem item5 = new MenuItem("Item 5", "Description 5", 15.0, 14.99, new ArrayList<>());
        MenuItem item6 = new MenuItem("Item 6", "Description 6", 15.0, 14.99, new ArrayList<>());
        MenuItem item7 = new MenuItem("Item 7", "Description 7", 15.0, 14.99, new ArrayList<>());


        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menu.add(item5);
        menu.add(item6);
        menu.add(item7);

        saveMenu(menu, "C:\\Users\\admin\\Documents\\CTAC-Program\\JavaRMS-Project\\src\\main\\java\\org\\example\\Menu.txt");
    }
}

