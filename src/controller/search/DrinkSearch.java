package controller.search;

import model.Drink;
import storage.DrinkStorage;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrinkSearch {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public void searchDrinkByType() {
        File csvFile = new File("data/drink.csv");
        List<Drink> drinks = drinkStorage.readDrinks();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            for (Drink drink : drinks) {
                writer.write(drink.toString());
                writer.newLine();
            }
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            boolean foundDrinkType = false;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter drink type to search: ");
                String drinkType = scanner.nextLine();

                Pattern pattern = Pattern.compile(drinkType + " - (.*?) MFG:");
                Matcher matcher = pattern.matcher(content);

                boolean matchFound = false;
                while (matcher.find()) {
                    System.out.println(matcher.group(1));
                    matchFound = true;
                }

                if (matchFound) {
                    foundDrinkType = true;
                } else {
                    System.out.println("No matches found for " + drinkType + ".");
                }
            } while (!foundDrinkType);

            reader.close();

        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
