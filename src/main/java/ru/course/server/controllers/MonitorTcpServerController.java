package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.MonitorJpaSpringRepository;
import ru.course.server.models.product.Monitor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@RequestMapping("/v1/monitors")

@RequiredArgsConstructor
@RestController
public class MonitorTcpServerController {
    private final MonitorJpaSpringRepository monitorJpaSpringRepository;

    @GetMapping
    public List<Monitor> getMonitors() {
        DateValidator.dateValidate(LocalDate.now());
        return monitorJpaSpringRepository.findAll();
    }

    @GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        return monitorJpaSpringRepository.findById(Long.valueOf(id))
                .orElseThrow(CustomNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        DateValidator.dateValidate(LocalDate.now());
        monitorJpaSpringRepository.deleteById(Long.valueOf(id));
        TimeChecker.timeCheck(LocalDateTime.now());
    }

    @PostMapping
    public void save(@RequestBody Monitor monitor) {
        DateValidator.dateValidate(LocalDate.now());
        monitorJpaSpringRepository.save(monitor);
        TimeChecker.timeCheck(LocalDateTime.now());
    }
}
