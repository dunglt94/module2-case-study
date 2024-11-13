package model;

import java.time.LocalDate;

public class Coffee extends Drink {
    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(2);
    }

    @Override
    public double getDiscountedPrice() {
        return getPrice();
    }

    @Override
    public String toString() {
        return "id: " + super.getId() +
                ", drink type: " + super.getType() +
                ", name: " + super.getName() +
                ", MFG: " + super.getManufacturingDate().format(DATE_FORMATTER) +
                ", EXP: " + this.getExpiryDate().format(DATE_FORMATTER) +
                ", price: " + this.getDiscountedPrice() +
                ", quantity: " + super.getQuantity();
    }
}
