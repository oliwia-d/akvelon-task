package pl.akvelon.akvelontask.repository.creature;

import org.springframework.stereotype.Repository;
import pl.akvelon.akvelontask.model.creature.CreatureType;
import pl.akvelon.akvelontask.model.creature.man.Man;

@Repository
public interface ManRepository extends CreatureRepository<Man> {

    default CreatureType getType() {
        return CreatureType.MAN;
    }

}
