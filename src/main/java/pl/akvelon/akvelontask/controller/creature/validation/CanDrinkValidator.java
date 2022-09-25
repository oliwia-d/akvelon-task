package pl.akvelon.akvelontask.controller.creature.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.controller.creature.CreatureDrinkCommand;
import pl.akvelon.akvelontask.repository.creature.CreatureRepositoryManager;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class CanDrinkValidator implements ConstraintValidator<CanDrink, CreatureDrinkCommand> {

    private final CreatureRepositoryManager repositoryManager;

    @Override
    public boolean isValid(CreatureDrinkCommand command, ConstraintValidatorContext constraintValidatorContext) {
        return repositoryManager.getRepository(command.getCreatureType()).findById(command.getCreatureId())
                .map(creature -> creature.canDrink(command.getVolume()))
                .orElse(false);
    }

}
