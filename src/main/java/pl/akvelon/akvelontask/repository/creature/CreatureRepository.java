package pl.akvelon.akvelontask.repository.creature;

import org.springframework.data.repository.NoRepositoryBean;
import pl.akvelon.akvelontask.model.creature.Creature;
import pl.akvelon.akvelontask.model.creature.CreatureType;
import pl.akvelon.akvelontask.repository.GenericRepository;

@NoRepositoryBean
public interface CreatureRepository<T extends Creature> extends GenericRepository<T, CreatureType> {

    default CreatureType getType() {
        return CreatureType.DEFAULT;
    }

}
