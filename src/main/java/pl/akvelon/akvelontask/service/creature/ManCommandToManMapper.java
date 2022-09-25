package pl.akvelon.akvelontask.service.creature;

import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.controller.creature.man.CreateManCommand;
import pl.akvelon.akvelontask.model.creature.CreatureType;
import pl.akvelon.akvelontask.model.creature.man.Man;

@Component
public class ManCommandToManMapper {

    public Man map(CreateManCommand command) {
        return Man.builder()
                .currentVolume(command.getCurrentVolume())
                .maxVolume(command.getMaxVolume())
                .type(CreatureType.MAN)
                .build();
    }
}
