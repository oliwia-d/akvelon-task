package pl.akvelon.akvelontask.repository.creature;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.exception.NotFoundException;
import pl.akvelon.akvelontask.model.creature.Creature;
import pl.akvelon.akvelontask.model.creature.CreatureType;
import pl.akvelon.akvelontask.model.creature.man.Man;
import pl.akvelon.akvelontask.repository.GenericRepository;
import pl.akvelon.akvelontask.repository.GenericRepositoryManager;

@Component
@RequiredArgsConstructor
public class CreatureRepositoryManager {

    private final GenericRepositoryManager<Creature, CreatureType> repositoryManager;

    public GenericRepository<? extends Creature, CreatureType> getRepository(CreatureType type) {
        return repositoryManager.getRepository(type);
    }

    public <T extends Creature> Creature saveCreature(T creature) {
        return switch (creature.getType()) {
            case MAN -> repositoryManager.saveContainer(creature, Man.class, ManRepository.class);
            case DEFAULT -> throw new NotFoundException(CreatureRepository.class);
        };
    }

}
