package view;

import controller.DrinkManager;
import model.Drink;

import java.util.Scanner;

public class Main {
    private static final DrinkManager drinkManager = new DrinkManager();
    public static void main(String[] args) {
        while (true) {
            System.out.println("Drink Storage Manager");
            System.out.println("1. Show drink list");
            System.out.println("2. Add drink");
            System.out.println("3. Edit drink");
            System.out.println("4. Remove drink");
            System.out.println("5. Sort drink list");
            System.out.println("6. Search drink by type");
            System.out.println("7. Export list to csv file");
            System.out.println("8. Exit");

            int userChoice = choice();
            switch (userChoice) {
                case 1:
                    drinkManager.printList();
                    isContinue();
                    break;
                case 2:
                    choiceDrinkType();
                    break;
                case 3:
                    drinkManager.editDrink();
                    isContinue();
                    break;
                case 4:
                    drinkManager.removeDrink();
                    isContinue();
                    break;
                case 5:
                    sortMenu();
                    break;
                case 6:
                    searchMenu();
                    break;
                case 7:
                    drinkManager.exportListToCSVFile();
                    isContinue();
                    break;
                case 8:
                    System.out.println("Have a nice day!");
                    System.exit(0);
                default:
                    System.out.println("Not a valid choice. Try again.");
            }
        }
    }

    private static void isContinue() {
        System.out.println("Do you want to continue?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int userChoice = choice();

        switch (userChoice) {
            case 1:
                break;
            case 2:
                System.out.println("Have a nice day!");
                System.exit(0);
            default:
                System.out.println("Not a valid choice. Try again.");
                isContinue();
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
        Drink newDrink = null;
        while (newDrink == null) {
            System.out.println("Choose drink type:");
            System.out.println("1. Beer");
            System.out.println("2. Coffee");
            System.out.println("3. Juice");
            System.out.println("4. Milk");
            System.out.println("5. Soft drink");
            System.out.println("6. Back");

            int userChoice = choice();

            if (userChoice == 6) {
                System.out.println("Going back to the main menu.");
                return;
            }
            newDrink = drinkManager.addDrink(userChoice);
        }
        isContinue();
    }

    private static void sortMenu() {
        while (true) {
            System.out.println("Choose sort method:");
            System.out.println("1. Sort by price ascending");
            System.out.println("2. Sort by price descending");
            System.out.println("3. Sort by drink type");
            System.out.println("4. Back");

            int userChoice = choice();

            if (userChoice == 4) {
                System.out.println("Going back to the main menu.");
                break;
            }

            if (userChoice == 1 || userChoice == 2 || userChoice == 3) {
                drinkManager.sortDrinks(userChoice);
                break;
            }
        }
        isContinue();
    }

    private static void searchMenu() {
        while (true) {
            System.out.println("Choose search method:");
            System.out.println("1. Search by drink type");
            System.out.println("2. Search by key word");
            System.out.println("3. Back");

            int userChoice = choice();

            if (userChoice == 3) {
                System.out.println("Going back to the main menu.");
                break;
            }

            if (userChoice == 1 || userChoice == 2) {
                drinkManager.searchDrink(userChoice);
                break;
            }
        }
        isContinue();
    }
}
