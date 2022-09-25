package pl.akvelon.akvelontask.repository.container;

import org.springframework.data.repository.NoRepositoryBean;
import pl.akvelon.akvelontask.model.container.Container;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.repository.GenericRepository;

@NoRepositoryBean
public interface ContainerRepository<T extends Container> extends GenericRepository<T, ContainerType> {

    default ContainerType getType() {
        return ContainerType.DEFAULT;
    }

}
