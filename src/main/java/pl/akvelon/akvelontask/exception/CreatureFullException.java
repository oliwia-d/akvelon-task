package pl.akvelon.akvelontask.exception;

import pl.akvelon.akvelontask.model.creature.Creature;

public class CreatureFullException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Volume: %d is too large for creature with available volume: %d.";
    public CreatureFullException(Creature creature, int volume) {
        super(String.format(MESSAGE_FORMAT, volume, creature.getMaxVolume() - creature.getCurrentVolume()));
    }
}
