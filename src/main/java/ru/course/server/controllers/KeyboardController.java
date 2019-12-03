package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.KeyboardRepository;
import ru.course.server.models.product.Keyboard;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/keyboards")
public class KeyboardController {
    private final KeyboardRepository keyboardRepository;

    @GetMapping
    public List<Keyboard> getKeyboards() {
        return keyboardRepository.findAll();
    }

    @GetMapping("/{id}")
    public Keyboard getKeyboardById(@PathVariable String id) {
        return keyboardRepository.findById(Long.valueOf(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping
    public void save(@RequestBody Keyboard keyboard) {
        keyboardRepository.save(keyboard);
    }

    @DeleteMapping("/{id}")
    public void deleteKeyboardById(@PathVariable String id) {
        keyboardRepository.deleteById(Long.valueOf(id));
    }
}
