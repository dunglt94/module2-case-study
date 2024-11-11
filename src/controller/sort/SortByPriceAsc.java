package controller.sort;

import model.Drink;

import java.util.List;

public class SortByPriceAsc implements SortStrategy{
    @Override
    public void sort(List<Drink> drinks) {
        boolean needNextPass = true;
        for (int i = 1; i < drinks.size() && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < drinks.size() - i; j++) {
                if (drinks.get(j).getPrice() > drinks.get(j + 1).getPrice()) {
                    Drink drink = drinks.get(j);
                    drinks.set(j, drinks.get(j + 1));
                    drinks.set(j + 1, drink);
                    needNextPass = true;
                }
            }
        }
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }
}
