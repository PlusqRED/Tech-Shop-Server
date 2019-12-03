package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.SmartphoneRepository;
import ru.course.server.models.product.Smartphone;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/smartphones")
public class SmartphoneController {
    private final SmartphoneRepository smartphoneRepository;

    @GetMapping
    public List<Smartphone> getSmartphones() {
        return smartphoneRepository.findAll();
    }

    @GetMapping("/{id}")
    public Smartphone getSmartphoneById(@PathVariable String id) {
        return smartphoneRepository.findById(Long.valueOf(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        smartphoneRepository.deleteById(Long.valueOf(id));
    }

    @PostMapping
    public void save(@RequestBody Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }
}
