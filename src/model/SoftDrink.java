package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SoftDrink extends Drink {


    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(2);
    }

    @Override
    public double getRealPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "id: " + super.getId() +
                ", drink type" + super.getType() +
                ", name: " + super.getName() +
                ", MFG: " + super.getManufacturingDate().format(formatter) +
                ", EXP: " + this.getExpiryDate().format(formatter) +
                ", price: " + this.getRealPrice() +
                ", quantity: " + super.getQuantity();
    }
}
