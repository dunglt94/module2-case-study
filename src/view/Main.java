package view;

import controller.DrinkManager;
import model.Drink;

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

            switch (choice()) {
                case 1:
                    drinkManager.printList();
                    break;
                case 2:
                    choiceDrinkType();
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
        int choice = 0;
        try {
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            choice =  scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a number.");

        }
        return choice;
    }

    private static void choiceDrinkType() {
        Drink newDrink;
        do {
            System.out.println("Choose drink type:");
            System.out.println("1. Beer");
            System.out.println("2. Coffee");
            System.out.println("3. Juice");
            System.out.println("4. Milk");
            System.out.println("5. Soft drink");
            System.out.println("6. Back");

            newDrink = drinkManager.addDrink(choice());
        } while (newDrink == null && choice() != 6);
    }
}
