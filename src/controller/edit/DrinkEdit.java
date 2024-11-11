package controller.edit;

import controller.add.DrinkInformation;
import controller.validate_input.InputValidation;
import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class DrinkEdit {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();
    private InputValidation inputValidation;
    private DrinkInformation drinkInformation;

    public DrinkEdit(InputValidation inputValidation, DrinkInformation drinkInformation) {
        this.inputValidation = inputValidation;
        this.drinkInformation = drinkInformation;
    }

    public List<Drink> editDrink() {
        System.out.println("Editing Drink:");
        String id = inputValidation.isInTheList();

        for (Drink drink : drinks) {
            if (drink.getId().equals(id)) {
                System.out.println(drink);
                drinkInformation.inputDrinkInformation(drink);
                break;
            }
        }
        System.out.println("Drink id " + id + " edited");
        return drinks;

    }
}
