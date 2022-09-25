package pl.akvelon.akvelontask.service.creature;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akvelon.akvelontask.controller.creature.man.CreateManCommand;
import pl.akvelon.akvelontask.model.creature.man.ManDto;
import pl.akvelon.akvelontask.repository.creature.ManRepository;

@Service
@RequiredArgsConstructor
public class ManService {

    private final ManRepository repository;
    private final ManCommandToManMapper mapper;

    public ManDto createMan(CreateManCommand command) {
        return ManDto.of(repository.save(mapper.map(command)));
    }

}
