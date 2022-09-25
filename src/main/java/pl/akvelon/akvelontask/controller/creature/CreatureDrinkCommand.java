package pl.akvelon.akvelontask.controller.creature;

import lombok.Getter;
import lombok.Setter;
import pl.akvelon.akvelontask.controller.creature.validation.CanDrink;
import pl.akvelon.akvelontask.controller.creature.validation.CanRemove;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.model.creature.CreatureType;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@CanDrink
@CanRemove
public class CreatureDrinkCommand {

    @NotNull
    private Long creatureId;
    @NotNull
    private CreatureType creatureType;

    @NotNull
    private Long containerId;
    @NotNull
    private ContainerType containerType;

    @NotNull
    private Integer volume;

}
