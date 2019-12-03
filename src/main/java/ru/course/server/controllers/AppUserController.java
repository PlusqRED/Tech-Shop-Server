package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.exceptions.EntityNotFoundException;
import ru.course.server.daos.AppUserRepository;
import ru.course.server.models.users.AppUser;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class AppUserController {

    private final AppUserRepository appUserRepository;

    @GetMapping("/{login}")
    public AppUser getAppUserByLogin(@PathVariable String login) {
        return appUserRepository.findByLogin(login)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PutMapping("/validate")
    public Boolean validate(@RequestBody AppUser appUser) {
        Optional<AppUser> user = appUserRepository.findByLogin(appUser.getLogin());
        return user.map(e -> e.getPassword().equals(appUser.getPassword()))
                .orElse(false);
    }

    @PostMapping
    public void create(@RequestBody AppUser appUser) {
        appUserRepository.save(appUser);
    }

}
