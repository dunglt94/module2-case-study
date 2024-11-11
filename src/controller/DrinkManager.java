package controller;

import controller.add.AddDrinkFacade;
import controller.add.DrinkInformation;
import controller.add.DrinkTypeChoice;
import controller.edit.DrinkEdit;
import controller.remove.DrinkRemove;
import controller.sort.SortByPriceAsc;
import controller.sort.SortSelection;
import controller.validate_input.InputValidation;
import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class DrinkManager {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();

    public void printList() {
        try {
            if (drinks.isEmpty()) {
                System.out.println("There are no drinks.");
            } else {
                System.out.println("Drink List");
                for (Drink drink : drinks) {
                    System.out.println(drink);
                }
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

    public void editDrink() {
        DrinkEdit drinkEdit = new DrinkEdit(new InputValidation(), new DrinkInformation());
        drinks = drinkEdit.editDrink();
        drinkStorage.writeDrinks(drinks);
    }

    public void removeDrink() {
        DrinkRemove drinkRemove = new DrinkRemove(new InputValidation());
        drinks = drinkRemove.removeDrink();
        drinkStorage.writeDrinks(drinks);
    }

    public void sortDrinks(int choice) {
        SortSelection sortSelection = new SortSelection();
        sortSelection.sortList(choice);
    }

    public void searchDrink() {}

}
