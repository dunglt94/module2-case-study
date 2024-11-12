package controller.search;

import model.Drink;
import storage.DrinkStorage;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkSearch {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public void searchDrinkByType() {
        List<Drink> drinks = drinkStorage.readDrinks();
        try {
            StringBuilder content = new StringBuilder();

            for (Drink drink : drinks) {
                content.append(drink.toString()).append("\n");
            }

            boolean foundDrinkType = false;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter drink type to search: ");
                String drinkType = scanner.nextLine();

                Pattern pattern = Pattern.compile("(.*?), (.*?) MFG:");
                Matcher matcher = pattern.matcher(content);

                boolean matchFound = false;

                while (matcher.find()) {
                    if (drinkType.equalsIgnoreCase(matcher.group(1))) {
                        System.out.println(matcher.group(2));
                        matchFound = true;
                    }
                }

                if (matchFound) {
                    foundDrinkType = true;
                } else {
                    System.out.println("No matches found for " + drinkType + ". Try again.");
                }
            } while (!foundDrinkType);

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
