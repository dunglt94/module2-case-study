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
                drink.setType("Beer");
                return drink;
            case 2:
                drink = drinkFactory.getDrink(DrinkType.COFFEE);
                drink.setType("Coffee");
                return drink;
            case 3:
                drink = drinkFactory.getDrink(DrinkType.JUICE);
                drink.setType("Juice");
                return drink;
            case 4:
                drink = drinkFactory.getDrink(DrinkType.MILK);
                drink.setType("Milk");
                return drink;
            case 5:
                drink = drinkFactory.getDrink(DrinkType.SOFT_DRINK);
                drink.setType("Soft Drink");
                return drink;
            case 6:
                return null;
            default:
                System.out.println("Not a valid choice. Try again.");
                return null;
        }
    }
}
