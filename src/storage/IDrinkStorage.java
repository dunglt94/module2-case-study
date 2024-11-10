package storage;

import model.Drink;

import java.util.List;

public interface IDrinkStorage {
    void writeDrinks(List<Drink> drinks);
    List<Drink> readDrinks();
}
