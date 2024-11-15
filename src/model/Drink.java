package model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Drink implements Discount, Comparable<Drink>, Serializable {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Serial
    private static final long serialVersionUID = -5392678725166805118L;
    private String id;
    private String type;
    private String name;
    private LocalDate manufacturingDate;
    private double price;
    private int quantity;

    public Drink() {}

    public Drink(String id, String type, String name, LocalDate manufacturingDate, double price, int quantity) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.manufacturingDate = manufacturingDate;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "id: " + id +
                ", drink type: " + type +
                ", name: " + name +
                ", MFG: " + manufacturingDate.format(DATE_FORMATTER) +
                ", price: " + price +
                ", quantity: " + quantity;
    }

    @Override
    public int compareTo(Drink o) {
        return Integer.parseInt(this.getId()) - Integer.parseInt(o.getId());
    }
}
