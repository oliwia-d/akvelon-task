package pl.akvelon.akvelontask.controller;

import pl.akvelon.akvelontask.model.*;

public class InteractionController implements Drinkable {

    @Override
    public void drink(Creature creature, Dish dish, int volume) {
        int creatureVol = creature.getVolume();
        int dishVol = dish.getVolume();
        creatureVol += volume;
        dishVol -= volume;
        creature.setVolume(creatureVol);
        dish.setVolume(dishVol);
        System.out.println("The volume of " + creature.getClass().toString() + " is: " + creatureVol + ".");
        System.out.println("The volume of " + dish.getClass().toString() + " is: " + dishVol + ".");
    }
}
