package pl.akvelon.akvelontask.repository.container;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.exception.NotFoundException;
import pl.akvelon.akvelontask.model.container.Container;
import pl.akvelon.akvelontask.model.container.ContainerType;
import pl.akvelon.akvelontask.model.container.bottle.Bottle;
import pl.akvelon.akvelontask.repository.GenericRepository;
import pl.akvelon.akvelontask.repository.GenericRepositoryManager;

@Component
@RequiredArgsConstructor
public class ContainerRepositoryManager {

    private final GenericRepositoryManager<Container, ContainerType> repositoryManager;

    public GenericRepository<? extends Container, ContainerType> getRepository(ContainerType type) {
        return repositoryManager.getRepository(type);
    }

    public <T extends Container> Container saveContainer(T container) {
        return switch (container.getType()) {
            case BOTTLE -> repositoryManager.saveContainer(container, Bottle.class, BottleRepository.class);
            case DEFAULT -> throw new NotFoundException(ContainerRepository.class);
        };
    }

}
