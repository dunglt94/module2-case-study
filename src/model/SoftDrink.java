package model;

import java.time.LocalDate;

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
        return "Soft drink - id: " + super.getId() +
                ", name: " + super.getName() +
                ", MFG: " + super.getManufacturingDate() +
                ", EXP: " + this.getExpiryDate() +
                ", price: " + this.getRealPrice() +
                ", quantity: " + super.getQuantity();
    }
}
