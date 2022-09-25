package pl.akvelon.akvelontask.service.container;

import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.controller.container.bottle.CreateBottleCommand;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.model.container.bottle.Bottle;

@Component
public class BottleCommandToBottleMapper {

    public Bottle map(CreateBottleCommand command) {
        return Bottle.builder()
                .currentVolume(command.getCurrentVolume())
                .maxVolume(command.getMaxVolume())
                .type(ContainerType.BOTTLE)
                .build();
    }
}
