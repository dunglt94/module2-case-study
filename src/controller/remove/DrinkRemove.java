package controller.remove;

import controller.validate_input.InputValidation;
import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class DrinkRemove {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();
    private InputValidation inputValidation;

    public DrinkRemove(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }

    public List<Drink> removeDrink() {
        if (drinks.isEmpty()) {
            System.out.println("No drinks found.");
        } else {
            String id = inputValidation.isInTheList();
            for (Drink drink : drinks) {
                if (drink.getId().equals(id)) {
                    System.out.println("Removed drink:");
                    System.out.println(drink);
                    drinks.remove(drink);
                    break;
                }
            }
        }
        return drinks;
    }
}
