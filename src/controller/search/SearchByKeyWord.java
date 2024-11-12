package controller.search;

import model.Drink;
import storage.DrinkStorage;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchByKeyWord {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public void searchDrink() {
        List<Drink> drinks = drinkStorage.readDrinks();
        try {
            boolean foundKeyWord = false;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter key word to search: ");
                String keyWord = scanner.nextLine();
                String[] words = keyWord.toLowerCase().split("\\s+");
                boolean matchFound = false;

                if (words.length > 1) {
                    for (Drink drink : drinks) {
                        Pattern pattern = Pattern.compile("name: (.*?), manufacturing");
                        Matcher matcher = pattern.matcher(drink.toString());
                        while (matcher.find()) {
                            if (matcher.group(1).toLowerCase().contains(keyWord.toLowerCase())) {
                                System.out.println(drink);
                                matchFound = true;
                            }
                        }
                    }
                    if (matchFound) {
                        foundKeyWord = true;
                    } else {
                        System.out.println("No matches found for " + keyWord + ". Try again.");
                    }
                } else if (words.length == 1) {
                    for (String word : words) {
                        Pattern pattern = Pattern.compile("name: (.*?), manufacturing");
                        for (Drink drink : drinks) {
                            Matcher matcher = pattern.matcher(drink.toString());
                            while (matcher.find()) {
                                if (matcher.group(1).toLowerCase().contains(word.toLowerCase())) {
                                    System.out.println(drink);
                                    matchFound = true;
                                }
                            }
                        }

                        if (matchFound) {
                            foundKeyWord = true;
                        } else {
                            System.out.println("No matches found for " + word + ". Try again.");
                        }
                    }
                }

            } while (!foundKeyWord);
        } catch (Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }
}
