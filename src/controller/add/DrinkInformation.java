package controller.add;

import model.Drink;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DrinkInformation {
    public void inputDrinkInformation(Drink drink) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        drink.setName(scanner.nextLine());
        inputManufacturingDate(drink, scanner);
        inputPrice(drink, scanner);
        inputQuantity(drink, scanner);
    }

    private void inputPrice(Drink drink, Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter price: ");
                double price = Double.parseDouble(scanner.nextLine());
                drink.setPrice(price);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void inputQuantity(Drink drink, Scanner scanner) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter quantity: ");
                int quantity = parseInt(scanner.nextLine());
                drink.setQuantity(quantity);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void inputManufacturingDate(Drink drink, Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean validDate = false;
        while (!validDate) {
            try {
                System.out.print("Enter manufacturing date (dd-MM-yyyy): ");
                String dateString = scanner.nextLine();
                LocalDate date = LocalDate.parse(dateString, formatter);
                drink.setManufacturingDate(date);
                validDate = true;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
            }
        }
    }
}
