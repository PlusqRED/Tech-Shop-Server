package ru.course.server.data.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.daos.*;
import ru.course.server.data.Loader;
import ru.course.server.models.product.Keyboard;
import ru.course.server.models.product.Monitor;
import ru.course.server.models.product.Mouse;
import ru.course.server.models.product.Smartphone;
import ru.course.server.models.users.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements Loader {

    private final Gson googleJson;
    private final RoleJpaSpringRepository roleJpaSpringRepository;
    private final MonitorJpaSpringRepository monitorJpaSpringRepository;
    private final MouseJpaSpringRepository mouseJpaSpringRepository;
    private final SmartphoneJpaSpringRepository smartphoneJpaSpringRepository;
    private final KeyboardJpaSpringRepository keyboardJpaSpringRepository;

    @Override
    public void initRoles(String rolesDataJsonType) {
        DateValidator.dateValidate(LocalDate.now());
        if (roleJpaSpringRepository.count() == 0) {
            DateValidator.dateValidate(LocalDate.now());
            List<Role> roles = googleJson.fromJson(rolesDataJsonType, new TypeToken<List<Role>>() {
            }.getType());
            TimeChecker.timeCheck(LocalDateTime.now());
            roleJpaSpringRepository.saveAll(roles);
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @Override
    public void initMonitors(String monitorsDataJsonType) {
        DateValidator.dateValidate(LocalDate.now());
        if (monitorJpaSpringRepository.count() == 0) {
            DateValidator.dateValidate(LocalDate.now());
            monitorJpaSpringRepository.deleteAll();
            TimeChecker.timeCheck(LocalDateTime.now());
            List<Monitor> monitors = googleJson.fromJson(monitorsDataJsonType, new TypeToken<List<Monitor>>() {
            }.getType());
            TimeChecker.timeCheck(LocalDateTime.now());
            monitorJpaSpringRepository.saveAll(monitors);
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @Override
    public void initSmartphones(String smartphonesDataJsonType) {
        DateValidator.dateValidate(LocalDate.now());
        if (smartphoneJpaSpringRepository.count() == 0) {
            DateValidator.dateValidate(LocalDate.now());
            smartphoneJpaSpringRepository.deleteAll();
            TimeChecker.timeCheck(LocalDateTime.now());
            List<Smartphone> smartphones = googleJson.fromJson(smartphonesDataJsonType, new TypeToken<List<Smartphone>>() {
            }.getType());
            TimeChecker.timeCheck(LocalDateTime.now());
            smartphoneJpaSpringRepository.saveAll(smartphones);
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @Override
    public void initKeyboards(String keyboardsDataJsonType) {
        DateValidator.dateValidate(LocalDate.now());
        if (keyboardJpaSpringRepository.count() == 0) {
            keyboardJpaSpringRepository.deleteAll();
            TimeChecker.timeCheck(LocalDateTime.now());
            List<Keyboard> keyboards = googleJson.fromJson(keyboardsDataJsonType, new TypeToken<List<Keyboard>>() {
            }.getType());
            TimeChecker.timeCheck(LocalDateTime.now());
            keyboardJpaSpringRepository.saveAll(keyboards);
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @Override
    public void initMouses(String mousesDataJsonType) {
        DateValidator.dateValidate(LocalDate.now());
        if (mouseJpaSpringRepository.count() == 0) {
            mouseJpaSpringRepository.deleteAll();
            TimeChecker.timeCheck(LocalDateTime.now());
            List<Mouse> mouses = googleJson.fromJson(mousesDataJsonType, new TypeToken<List<Mouse>>() {
            }.getType());
            TimeChecker.timeCheck(LocalDateTime.now());
            mouseJpaSpringRepository.saveAll(mouses);
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }
}
