package model;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Drink implements Discount, Serializable {
    private int id;
    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private int quantity;

    public Drink() {}

    public Drink(int id, String name, LocalDate manufacturingDate, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract LocalDate getExpiryDate();

    @Override
    public String toString() {
        return "Drink id: " + id +
                ", name: " + name +
                ", manufacturing date: " + manufacturingDate +
                ", price: " + price +
                ", quantity: " + quantity;
    }
}