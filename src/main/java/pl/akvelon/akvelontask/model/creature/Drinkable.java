package pl.akvelon.akvelontask.model.creature;

public interface Drinkable {
    void drink(int volumeToDrink);

    boolean canDrink(int volumeToDrink);

}
