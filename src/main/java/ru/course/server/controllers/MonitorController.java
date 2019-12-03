package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.MonitorRepository;
import ru.course.server.models.product.Monitor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/monitors")
public class MonitorController {
    private final MonitorRepository monitorRepository;

    @GetMapping
    public List<Monitor> getMonitors() {
        return monitorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Monitor getMonitorById(@PathVariable String id) {
        return monitorRepository.findById(Long.valueOf(id))
                .orElseThrow(EntityNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void deleteMonitorById(@PathVariable String id) {
        monitorRepository.deleteById(Long.valueOf(id));
    }

    @PostMapping
    public void save(@RequestBody Monitor monitor) {
        monitorRepository.save(monitor);
    }
}
