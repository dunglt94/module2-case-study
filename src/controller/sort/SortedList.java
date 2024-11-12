package controller.sort;

import model.Drink;

import java.util.List;

public class SortedList {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(List<Drink> drinks) {
        strategy.sort(drinks);
    }
}
