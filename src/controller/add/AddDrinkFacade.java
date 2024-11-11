package controller.add;

import controller.validate_input.InputValidation;
import model.Drink;

public class AddDrinkFacade {
    private DrinkTypeChoice drinkTypeChoice;
    private InputValidation inputValidation;
    private DrinkInformation drinkInformation;

    public AddDrinkFacade(DrinkTypeChoice drinkTypeChoice,
                          InputValidation inputValidation, DrinkInformation drinkInformation) {
        this.drinkTypeChoice = drinkTypeChoice;
        this.inputValidation = inputValidation;
        this.drinkInformation = drinkInformation;
    }

    public Drink addNewDrink(int choice) {
        Drink newDrink = drinkTypeChoice.getDrink(choice);
        if (newDrink != null) {
            newDrink.setId(inputValidation.isIdAvailable());
            drinkInformation.inputDrinkInformation(newDrink);
            System.out.println("Added drink:");
            System.out.println(newDrink);
        }
        return newDrink;
    }
}
