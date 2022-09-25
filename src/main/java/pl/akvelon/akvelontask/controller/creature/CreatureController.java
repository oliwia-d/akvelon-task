package pl.akvelon.akvelontask.controller.creature;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akvelon.akvelontask.service.creature.CreatureDrinkService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/creature")
public class CreatureController {

    private final CreatureDrinkService service;

    @PostMapping("/drink")
    public ResponseEntity<Void> drink(@RequestBody @Valid CreatureDrinkCommand command) {
        service.drink(command);
        return ResponseEntity.noContent().build();
    }

}
