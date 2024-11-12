package controller.search;

import controller.sort.SortByDrinkType;
import controller.sort.SortByPriceAsc;
import controller.sort.SortByPriceDes;

public class SearchSelection {
    public void searchDrink(int choice) {
        SearchMethod searchMethod = new SearchMethod();
        switch (choice) {
            case 1:
                searchMethod.setSearchStrategy(new SearchByDrinkType());
                searchMethod.search();
                break;
            case 2:
                searchMethod.setSearchStrategy(new SearchByKeyWord());
                searchMethod.search();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
