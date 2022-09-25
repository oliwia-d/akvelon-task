package pl.akvelon.akvelontask.service.creature;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akvelon.akvelontask.controller.creature.CreatureDrinkCommand;
import pl.akvelon.akvelontask.exception.NotFoundException;
import pl.akvelon.akvelontask.model.container.Container;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.model.creature.Creature;
import pl.akvelon.akvelontask.model.creature.CreatureType;
import pl.akvelon.akvelontask.repository.container.ContainerRepositoryManager;
import pl.akvelon.akvelontask.repository.creature.CreatureRepositoryManager;

@Service
@RequiredArgsConstructor
public class CreatureDrinkService {

    private final CreatureRepositoryManager creatureRepositoryManager;
    private final ContainerRepositoryManager containerRepositoryManager;

    public void drink(CreatureDrinkCommand command) {
        Creature creature = getCreature(command.getCreatureId(), command.getCreatureType());
        Container container = getContainer(command.getContainerId(), command.getContainerType());
        creature.drink(command.getVolume());
        container.remove(command.getVolume());
        saveState(creature, container);
    }

    private Creature getCreature(Long creatureId, CreatureType creatureType) {
        return creatureRepositoryManager.getRepository(creatureType).findById(creatureId)
                .orElseThrow(() -> new NotFoundException(Creature.class));
    }

    private Container getContainer(Long containerId, ContainerType containerType) {
        return containerRepositoryManager.getRepository(containerType).findById(containerId)
                .orElseThrow(() -> new NotFoundException(Container.class));
    }


    private void saveState(Creature creature, Container container) {
        creatureRepositoryManager.saveCreature(creature);
        containerRepositoryManager.saveContainer(container);
    }

}
