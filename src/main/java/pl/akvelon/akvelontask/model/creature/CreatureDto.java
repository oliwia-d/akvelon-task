package pl.akvelon.akvelontask.model.creature;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatureDto {

    private Integer currentVolume;
    private Integer maxVolume;
    private CreatureType type;

    public void apply(Creature creature) {
        this.currentVolume = creature.getCurrentVolume();
        this.maxVolume = creature.getMaxVolume();
        this.type = creature.getType();
    }

}
