package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.ColorJpaSpringRepository;
import ru.course.server.models.product.commons.Color;

import java.time.LocalDate;
import java.util.List;
@RequestMapping("/v1/colors")

@RequiredArgsConstructor
@RestController
public class ColorTcpServerController {

    private final ColorJpaSpringRepository colorJpaSpringRepository;

    @GetMapping
    public List<Color> getColors() {
        DateValidator.dateValidate(LocalDate.now());
        return colorJpaSpringRepository.findAll();
    }

    @GetMapping("/{id}")
    public Color getColorById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        return colorJpaSpringRepository.findById(Integer.valueOf(id))
                .orElseThrow(CustomNotFoundException::new);
    }
}
