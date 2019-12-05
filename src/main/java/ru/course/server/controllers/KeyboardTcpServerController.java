package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.KeyboardJpaSpringRepository;
import ru.course.server.models.product.Keyboard;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RequestMapping("/v1/keyboards")

@RequiredArgsConstructor
@RestController
public class KeyboardTcpServerController {
    private final KeyboardJpaSpringRepository keyboardJpaSpringRepository;

    @GetMapping
    public List<Keyboard> getKeyboards() {
        DateValidator.dateValidate(LocalDate.now());
        return keyboardJpaSpringRepository.findAll();
    }

    @GetMapping("/{id}")
    public Keyboard getKeyboardById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        return keyboardJpaSpringRepository.findById(Long.valueOf(id))
                .orElseThrow(CustomNotFoundException::new);
    }

    @PostMapping
    public void save(@RequestBody Keyboard keyboard) {
        DateValidator.dateValidate(LocalDate.now());
        keyboardJpaSpringRepository.save(keyboard);
        TimeChecker.timeCheck(LocalDateTime.now());
    }

    @DeleteMapping("/{id}")
    public void deleteKeyboardById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        keyboardJpaSpringRepository.deleteById(Long.valueOf(id));
        TimeChecker.timeCheck(LocalDateTime.now());
    }
}
