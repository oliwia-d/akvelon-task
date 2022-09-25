package pl.akvelon.akvelontask.controller.creature.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.controller.creature.CreatureDrinkCommand;
import pl.akvelon.akvelontask.repository.container.ContainerRepositoryManager;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class CanRemoveValidator implements ConstraintValidator<CanRemove, CreatureDrinkCommand> {

    private final ContainerRepositoryManager repositoryManager;

    @Override
    public boolean isValid(CreatureDrinkCommand command, ConstraintValidatorContext constraintValidatorContext) {
        return repositoryManager.getRepository(command.getContainerType()).findById(command.getContainerId())
                .map(container -> container.canRemove(command.getVolume()))
                .orElse(false);
    }

}
