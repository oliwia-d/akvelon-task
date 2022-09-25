package pl.akvelon.akvelontask.service.container;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akvelon.akvelontask.controller.container.bottle.CreateBottleCommand;
import pl.akvelon.akvelontask.model.container.bottle.BottleDto;
import pl.akvelon.akvelontask.repository.container.BottleRepository;

@Service
@RequiredArgsConstructor
public class BottleService {

    private final BottleRepository repository;
    private final BottleCommandToBottleMapper mapper;

    public BottleDto createBottle(CreateBottleCommand command) {
        return BottleDto.of(repository.save(mapper.map(command)));
    }

}
