package view;

import controller.DrinkManager;

import java.util.Scanner;

public class Main {
    private static DrinkManager drinkManager = new DrinkManager();
    public static void main(String[] args) {
        while (true) {
            System.out.println("Drink Manager");
            System.out.println("1. Show drink list");
            System.out.println("2. Add drink");
            System.out.println("3. Edit drink");
            System.out.println("4. Remove drink");
            System.out.println("5. Sort drink list");
            System.out.println("6. Search drink by type");
            System.out.println("7. Exit");
            System.out.println("Enter your choice");

            switch (choice()) {
                case 1:
                    drinkManager.printList();
                    break;
                case 2:
                    drinkManager.addDrink();
                    break;
                case 3:
                    drinkManager.editDrink();
                    break;
                case 4:
                    drinkManager.removeDrink();
                    break;
                case 5:
                    drinkManager.sortDrinks();
                    break;
                case 6:
                    drinkManager.searchDrink();
                    break;
                case 7:
                    System.out.println("Have a nice day!");
                    System.exit(0);
                default:
                    System.out.println("Not a valid choice. Try again.");
            }
        }
    }

    private static int choice() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
