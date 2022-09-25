package pl.akvelon.akvelontask.repository.container;

import org.springframework.stereotype.Repository;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.model.container.bottle.Bottle;

@Repository
public interface BottleRepository extends ContainerRepository<Bottle> {

    default ContainerType getType() {
        return ContainerType.BOTTLE;
    }

}
