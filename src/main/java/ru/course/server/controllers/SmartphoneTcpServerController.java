package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.SmartphoneJpaSpringRepository;
import ru.course.server.models.product.Smartphone;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/v1/smartphones")

@RequiredArgsConstructor
@RestController
public class SmartphoneTcpServerController {
    private final SmartphoneJpaSpringRepository smartphoneJpaSpringRepository;

    @GetMapping
    public List<Smartphone> getSmartphones() {
        DateValidator.dateValidate(LocalDate.now());
        return smartphoneJpaSpringRepository.findAll();
    }

    @GetMapping("/{id}")
    public Smartphone getSmartphoneById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        return smartphoneJpaSpringRepository.findById(Long.valueOf(id))
                .orElseThrow(CustomNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        smartphoneJpaSpringRepository.deleteById(Long.valueOf(id));
    }

    @PostMapping
    public void save(@RequestBody Smartphone smartphone) {
        DateValidator.dateValidate(LocalDate.now());
        smartphoneJpaSpringRepository.save(smartphone);
        TimeChecker.timeCheck(LocalDateTime.now());
    }
}
