package controller.importCSVFile;

import model.Drink;
import storage.DrinkStorage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {
    static DrinkStorage drinkStorage = DrinkStorage.getInstance();
    public void writeCSVFile() {
        List<Drink> drinks = drinkStorage.readDrinks();
        File file = new File("data/drinks.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Drink drink : drinks) {
                writer.write(drink.getId());
                writer.write(",");
                writer.write(drink.getName());
                writer.write(",");
                writer.write(drink.getManufacturingDate().toString());
                writer.write(",");
                writer.write(drink.getExpiryDate().toString());
                writer.write(",");
                writer.write(Double.toString(drink.getPrice()));
                writer.write(",");
                writer.write(Integer.toString(drink.getQuantity()));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public List<Drink> readCSVFile() {
        List<Drink> drinks = new ArrayList<>();
        File file = new File("data/drinks.csv");
        writeCSVFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] column = line.split(",");
                String id = column[0];
                String name = column[1];
                LocalDate manuManufacturingDate = LocalDate.parse(column[2]);
                double price = Double.parseDouble(column[4]);
                int quantity = Integer.parseInt(column[5]);
                Drink drink = new Drink(id, name, manuManufacturingDate, price, quantity) {
                    @Override
                    public double getRealPrice() {
                        return super.getPrice();
                    }

                    @Override
                    public LocalDate getExpiryDate() {
                        return super.getManufacturingDate().plusYears(2);
                    }
                };
                drinks.add(drink);
            }
            reader.close();
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return drinks;
    }
}
