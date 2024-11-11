package controller.sort;

import model.Drink;

import java.util.List;

public class SortByPriceDes implements SortStrategy{
    @Override
    public void sort(List<Drink> drinks) {
        for (int i = 0; i < drinks.size() - 1; i++) {
            double currentMax = drinks.get(i).getPrice();
            int currentMaxIndex = i;

            for (int j = i + 1; j < drinks.size(); j++) {
                if (currentMax < drinks.get(j).getPrice()) {
                    currentMax = drinks.get(j).getPrice();
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != i) {
                Drink temp = drinks.get(i);
                drinks.set(i, drinks.get(currentMaxIndex));
                drinks.set(currentMaxIndex, temp);
            }
        }
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }
}
