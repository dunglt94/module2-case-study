package model.drink_factory;

import model.*;

public class DrinkFactory {
    public Drink getDrink(DrinkType drinkType) {
        switch (drinkType) {
            case BEER:
                return new Beer();
            case COFFEE:
                return new Coffee();
            case JUICE:
                return new Juice();
            case MILK:
                return new Milk();
            case SOFT_DRINK:
                return new SoftDrink();
            default:
                throw new IllegalArgumentException("This drink type is unsupported");
        }
    }
}
