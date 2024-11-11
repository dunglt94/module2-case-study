package controller.sort;

import model.Drink;

import java.util.List;

public interface SortStrategy {
    void sort(List<Drink> drinks);
}
