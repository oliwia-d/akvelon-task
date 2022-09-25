package pl.akvelon.akvelontask.controller.container.bottle;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.akvelon.akvelontask.model.container.bottle.BottleDto;
import pl.akvelon.akvelontask.service.container.BottleService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bottle")
public class BottleController {

    private final BottleService service;

    @PostMapping
    public ResponseEntity<BottleDto> create(@RequestBody @Valid CreateBottleCommand command) {
        return ResponseEntity.ok(service.createBottle(command));
    }

}
