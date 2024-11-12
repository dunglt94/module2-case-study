package controller;

import controller.add.AddDrinkFacade;
import controller.add.DrinkInformation;
import controller.add.DrinkTypeChoice;
import controller.edit.DrinkEdit;
import controller.importCSVFile.CSVFileHandler;
import controller.remove.DrinkRemove;
import controller.search.SearchByKeyWord;
import controller.search.SearchSelection;
import controller.sort.SortSelection;
import controller.validate_input.InputValidation;
import model.Drink;
import storage.DrinkStorage;

import java.util.Collections;
import java.util.List;

public class DrinkManager {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();

    public void printList() {
        try {
            Collections.sort(drinks);
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
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
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

    public void searchDrink(int choice) {
        SearchSelection searchSelection = new SearchSelection();
        searchSelection.searchDrink(choice);
    }

    public void exportListToCSVFile() {
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        List<Drink> drinks = csvFileHandler.readCSVFile();

        System.out.println("Exporting list...");
        if (drinks.isEmpty()) {
            System.out.println("There are no drinks.");
        } else {
            for (Drink drink : drinks) {
                System.out.println(drink);
            }
            System.out.println("The list was exported successfully.");
        }
    }
}
