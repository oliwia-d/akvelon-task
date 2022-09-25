package pl.akvelon.akvelontask.controller.creature.man;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateManCommand {

    @NotNull
    private Integer maxVolume;
    private Integer currentVolume = 0;

}
