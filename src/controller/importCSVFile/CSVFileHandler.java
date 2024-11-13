package controller.importCSVFile;

import model.Drink;
import storage.DrinkStorage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler implements Serializable {
    @Serial
    private static final long serialVersionUID = 3285825483624923850L;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String COMMA_DELIMITER = ",";
    private static final String DATA_DRINKS_CSV = "data/drinks.csv";
    private static final String FILE_HEADER = "id,type,name,manufacturer date,expiry date,price,quantity";

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
                writer.write(drink.getType());
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getName());
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getManufacturingDate().format(DATE_FORMATTER));
                writer.write(COMMA_DELIMITER);
                writer.write(drink.getExpiryDate().format(DATE_FORMATTER));
                writer.write(COMMA_DELIMITER);
                writer.write(Double.toString(drink.getPrice()));
                writer.write(COMMA_DELIMITER);
                writer.write(Integer.toString(drink.getQuantity()));
                writer.newLine();
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while writing CSV file !!!");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        } catch (Exception e) {
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
            System.out.println("Error while reading CSV file !!!");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }

        return drinks;
    }

    private static Drink getDrink(String[] column) {
        String id = column[0];
        String type = column[1];
        String name = column[2];
        LocalDate manuManufacturingDate = null;

        try {
            manuManufacturingDate = LocalDate.parse(column[3], DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format for manufacturing date");
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
        double price = Double.parseDouble(column[5]);
        int quantity = Integer.parseInt(column[6]);
        return new Drink(id, type,name, manuManufacturingDate, price, quantity) {
            @Serial
            private static final long serialVersionUID = 3285825483624923850L;
            @Override
            public double getDiscountedPrice() {
                return super.getPrice();
            }

            @Override
            public LocalDate getExpiryDate() {
                return super.getManufacturingDate().plusYears(2);
            }
        };
    }
}