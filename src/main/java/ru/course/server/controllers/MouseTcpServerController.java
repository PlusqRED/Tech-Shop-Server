package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.MouseJpaSpringRepository;
import ru.course.server.models.product.Mouse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/v1/mouses")

@RequiredArgsConstructor
@RestController
public class MouseTcpServerController {
    private final MouseJpaSpringRepository mouseJpaSpringRepository;

    @GetMapping
    public List<Mouse> getMouses() {
        DateValidator.dateValidate(LocalDate.now());
        return mouseJpaSpringRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mouse getMouseById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        return mouseJpaSpringRepository.findById(Long.valueOf(id))
                .orElseThrow(CustomNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        mouseJpaSpringRepository.deleteById(Long.valueOf(id));
        TimeChecker.timeCheck(LocalDateTime.now());
    }

    @PostMapping
    public void save(@RequestBody Mouse mouse) {
        DateValidator.dateValidate(LocalDate.now());
        mouseJpaSpringRepository.save(mouse);
        TimeChecker.timeCheck(LocalDateTime.now());
    }
}
