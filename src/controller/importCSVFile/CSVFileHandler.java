package controller.importCSVFile;

import model.Drink;
import storage.DrinkStorage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler {
    private static final String COMMA_DELIMITER = ",";
    private static final String DATA_DRINKS_CSV = "data/drinks.csv";
    private static final String FILE_HEADER = "id,name,manufacturerDate,expiryDate,Price,Quantity";

    static DrinkStorage drinkStorage = DrinkStorage.getInstance();

    public void writeCSVFile() {
        List<Drink> drinks = drinkStorage.readDrinks();
        File file = new File("data/drinks.csv");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(FILE_HEADER);
            writer.newLine();

            for (Drink drink : drinks) {
                writer.write(drink.getId());
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getName());
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getManufacturingDate().toString());
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getExpiryDate().toString());
                writer.write(COMMA_DELIMITER);
                writer.write(Double.toString(drink.getPrice()));
                writer.write(COMMA_DELIMITER);
                writer.write(Integer.toString(drink.getQuantity()));
                writer.newLine();
                writer.flush();
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing CSV file !!!");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public List<Drink> readCSVFile() {
        List<Drink> drinks = new ArrayList<>();
        File file = new File(DATA_DRINKS_CSV);
        writeCSVFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter++;
                String[] column = line.split(COMMA_DELIMITER);
                if (counter == 1) continue;
                Drink drink = getDrink(column);
                drinks.add(drink);
            }
            reader.close();
        } catch (IOException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        return drinks;
    }

    private static Drink getDrink(String[] column) {
        String id = column[0];
        String name = column[1];
        LocalDate manuManufacturingDate = LocalDate.parse(column[2]);
        double price = Double.parseDouble(column[4]);
        int quantity = Integer.parseInt(column[5]);
        return new Drink(id, name, manuManufacturingDate, price, quantity) {
            @Override
            public double getRealPrice() {
                return super.getPrice();
            }

            @Override
            public LocalDate getExpiryDate() {
                return super.getManufacturingDate().plusYears(2);
            }
        };
    }
}
