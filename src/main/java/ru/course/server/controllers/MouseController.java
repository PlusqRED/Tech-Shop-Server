package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.MouseRepository;
import ru.course.server.models.product.Mouse;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/mouses")
public class MouseController {
    private final MouseRepository mouseRepository;

    @GetMapping
    public List<Mouse> getMouses() {
        return mouseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mouse getMouseById(@PathVariable String id) {
        return mouseRepository.findById(Long.valueOf(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        mouseRepository.deleteById(Long.valueOf(id));
    }

    @PostMapping
    public void save(@RequestBody Mouse mouse) {
        mouseRepository.save(mouse);
    }
}
