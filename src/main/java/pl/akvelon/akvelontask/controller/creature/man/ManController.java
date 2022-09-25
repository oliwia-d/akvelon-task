package pl.akvelon.akvelontask.controller.creature.man;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akvelon.akvelontask.model.creature.man.ManDto;
import pl.akvelon.akvelontask.service.creature.ManService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/man")
public class ManController {

    private final ManService service;

    @PostMapping
    public ResponseEntity<ManDto> create(@RequestBody @Valid CreateManCommand command) {
        return ResponseEntity.ok(service.createMan(command));
    }

}
