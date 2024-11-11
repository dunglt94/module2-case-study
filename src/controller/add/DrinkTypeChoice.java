package controller.add;

import model.Drink;
import model.drink_factory.DrinkFactory;
import model.drink_factory.DrinkType;

public class DrinkTypeChoice {
    public Drink getDrink(int choice) {
        DrinkFactory drinkFactory = new DrinkFactory();
        Drink drink;
        switch (choice) {
            case 1:
                drink = drinkFactory.getDrink(DrinkType.BEER);
                return drink;
            case 2:
                drink = drinkFactory.getDrink(DrinkType.COFFEE);
                return drink;
            case 3:
                drink = drinkFactory.getDrink(DrinkType.JUICE);
                return drink;
            case 4:
                drink = drinkFactory.getDrink(DrinkType.MILK);
                return drink;
            case 5:
                drink = drinkFactory.getDrink(DrinkType.SOFT_DRINK);
                return drink;
            case 6:
                return null;
            default:
                System.out.println("Not a valid choice. Try again.");
                return null;
        }
    }
}
