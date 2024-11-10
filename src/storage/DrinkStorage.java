package storage;

import model.Drink;

import java.io.*;
import java.util.List;

public class DrinkStorage implements IDrinkStorage {
    private DrinkStorage() {}

    private static DrinkStorage instance;
    public static DrinkStorage getInstance() {
        if (instance == null) {
            instance = new DrinkStorage();
        }
        return instance;
    }

    @Override
    public void writeDrinks(List<Drink> drinks) {
        File file = new File("data/drinks.txt");
        try {
            if (!file.exists()) {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error creating the file", e);
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(drinks);
        } catch (IOException e) {
            throw new RuntimeException("Error writing drinks to file", e);
        }
    }

    @Override
    public List<Drink> readDrinks() {
        File file = new File("data/drinks.txt");
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(file));
            Object o = os.readObject();
            //noinspection unchecked
            return (List<Drink>) o;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error reading drinks from file", e);
        }
    }
}