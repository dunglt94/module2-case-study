package controller.sort;

import model.Drink;
import storage.DrinkStorage;

import java.util.List;

public class SortSelection {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public void sortList(int choice) {
        List<Drink> drinks = drinkStorage.readDrinks();
        SortedList sortedList = new SortedList();
        switch (choice) {
            case 1:
                sortedList.setSortStrategy(new SortByPriceAsc());
                sortedList.sort(drinks);
                break;
            case 2:
                sortedList.setSortStrategy(new SortByPriceDes());
                sortedList.sort(drinks);
                break;
            case 3:
                sortedList.setSortStrategy(new SortByDrinkType());
                sortedList.sort(drinks);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
