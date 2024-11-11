package controller;

import controller.add.AddDrinkFacade;
import controller.add.DrinkInformation;
import controller.add.DrinkTypeChoice;
import controller.validate_input.InputValidation;
import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class DrinkManager {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();

    public void printList() {
        try {
            System.out.println("Drink List");
            for (Drink drink : drinks) {
                System.out.println(drink);
            }
        } catch (NullPointerException e) {
            System.out.println("The list is empty");
        }

    }

    public Drink addDrink(int choice) {
        AddDrinkFacade addDrinkFacade = new AddDrinkFacade(new DrinkTypeChoice(),
                new InputValidation() , new DrinkInformation());
        Drink newDrink = addDrinkFacade.addNewDrink(choice);
        if (newDrink != null) {
            drinks.add(newDrink);
            drinkStorage.writeDrinks(drinks);
        }
        return newDrink;
    }

    public void editDrink() {}

    public void removeDrink() {}

    public void sortDrinks() {}

    public void searchDrink() {}

}
