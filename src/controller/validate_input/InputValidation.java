package controller.validate_input;

import model.Drink;
import storage.DrinkStorage;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();

    public boolean validateIdInput(String id) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public boolean isContainId(String id) {
            List<Drink> drinks = drinkStorage.readDrinks();
            for (Drink drink : drinks) {
                if (drink.getId().equals(id)) {
                    return true;
                }
            }
            return false;
    }

    public String isIdAvailable() {
        Scanner scanner = new Scanner(System.in);
        String id;
        boolean validate;
        boolean isAvailable = false;
        do {
            System.out.print("Enter Id: ");
            id = scanner.nextLine();
            validate = validateIdInput(id);
            if (!validate) {
                System.out.println("Please only enter number.");
            } else {
                isAvailable = isContainId(id);
                if (isAvailable) {
                    System.out.println("Id is not available. A product with id " + id + " already exists.");
                    System.out.println("Please enter another id.");
                }
            }
        } while (!validate || isAvailable);
        return id;
    }

    public String isInTheList() {
        Scanner scanner = new Scanner(System.in);
        String id;
        boolean validate;
        boolean isContainId = false;
        do {
            System.out.print("Enter Id: ");
            id = scanner.nextLine();
            validate = validateIdInput(id);
            if (!validate) {
                System.out.println("Please only enter number.");
            } else {
                isContainId = isContainId(id);
                if (!isContainId) {
                    System.out.println("Product with id " + id + " does not exists.");
                    System.out.println("Please try again.");
                }
            }
        } while (!validate || !isContainId);
        return id;
    }
}
