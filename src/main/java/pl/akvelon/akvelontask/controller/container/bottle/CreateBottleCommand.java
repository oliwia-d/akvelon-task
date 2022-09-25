package pl.akvelon.akvelontask.controller.container.bottle;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateBottleCommand {

    @NotNull
    private Integer maxVolume;

    private Integer currentVolume = 0;

}
