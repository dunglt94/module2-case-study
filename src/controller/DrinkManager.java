package controller;

import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class DrinkManager {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public static List<Drink> drinks = drinkStorage.readDrinks();

    public void printList() {
        System.out.println("Drink List:");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }

    public void addDrink() {}

    public void editDrink() {}

    public void removeDrink() {}

    public void sortDrinks() {}

    public void searchDrink() {}

}
