package controller.sort;

import model.Drink;

import java.util.Comparator;
import java.util.List;

public class SortByDrinkType implements SortStrategy{
    @Override
    public void sort(List<Drink> drinks) {
        @SuppressWarnings("Convert2Lambda") Comparator <Drink> comparator = new Comparator<>() {
            @Override
            public int compare(Drink o1, Drink o2) {
                return o1.getType().compareTo(o2.getType());
            }
        };
        drinks.sort(comparator);
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }

}
