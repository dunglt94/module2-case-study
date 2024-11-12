package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Beer extends Drink {
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
        return "Beer, id: " + super.getId() +
                ", name: " + super.getName() +
                ", MFG: " + super.getManufacturingDate().format(formatter) +
                ", EXP: " + this.getExpiryDate().format(formatter) +
                ", price: " + this.getRealPrice() +
                ", quantity: " + super.getQuantity();
    }
}
