package pl.akvelon.akvelontask.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.akvelon.akvelontask.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GenericRepositoryManager<T, V> {

    private final List<GenericRepository<? extends T, V>> repositories;

    public GenericRepository<? extends T, V> getRepository(V type) {
        return repositories.stream()
                .filter(repository -> repository.getType() == type)
                .findAny()
                .orElseThrow(() -> new NotFoundException(type.getClass()));
    }

    public <I extends T> T saveContainer(Object entity, Class<I> containerType, Class<? extends GenericRepository<I, V>> repositoryType) {
        return repositories.stream()
                .filter(repositoryType::isInstance)
                .findAny()
                .map(repositoryType::cast)
                .flatMap(repository -> {
                    if (containerType.isInstance(entity)) {
                        return Optional.of(repository.save(containerType.cast(entity)));
                    } else {
                        return Optional.empty();
                    }
                })
                .orElseThrow(() -> new NotFoundException(repositoryType));
    }

}
