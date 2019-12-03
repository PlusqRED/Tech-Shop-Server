package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.ColorRepository;
import ru.course.server.models.product.commons.Color;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/colors")
public class ColorController {

    private final ColorRepository colorRepository;

    @GetMapping
    public List<Color> getColors() {
        return colorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Color getColorById(@PathVariable String id) {
        return colorRepository.findById(Integer.valueOf(id))
                .orElseThrow(EntityNotFoundException::new);
    }
}
