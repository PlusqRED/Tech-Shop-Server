package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.controllers.exceptions.CustomNotFoundException;
import ru.course.server.daos.AppUserJpaSpringRepository;
import ru.course.server.models.users.AppUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@RequestMapping("/v1/users")

@RequiredArgsConstructor
@RestController
public class AppUserTcpServerController {

    private final AppUserJpaSpringRepository appUserJpaSpringRepository;

    @GetMapping("/{login}")
    public AppUser getAppUserByLogin(@PathVariable String login) {
        DateValidator.dateValidate(LocalDate.now());
        return appUserJpaSpringRepository.findByLogin(login)
                .orElseThrow(CustomNotFoundException::new);
    }

    @PutMapping("/validate")
    public Boolean validate(@RequestBody AppUser appUser) {
        DateValidator.dateValidate(LocalDate.now());
        Optional<AppUser> user = appUserJpaSpringRepository.findByLogin(appUser.getLogin());
        TimeChecker.timeCheck(LocalDateTime.now());
        return user.map(e -> e.getPassword().equals(appUser.getPassword()))
                .orElse(false);
    }

    @PostMapping
    public void create(@RequestBody AppUser appUser) {
        DateValidator.dateValidate(LocalDate.now());
        appUserJpaSpringRepository.save(appUser);
        TimeChecker.timeCheck(LocalDateTime.now());
    }

}
