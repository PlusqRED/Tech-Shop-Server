package ru.course.server.data;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Log
@PropertySource("classpath:properties/local.properties")
public class Initer {

    private final Loader loader;

    private String materialsDataFileName;
    @Value("${data.filename.mouses}")
    private String mousesDataFileName;
    @Value("${data.filename.keyboards}")
    private String keyboardsDataFileName;
    @Value("${data.filename.roles}")
    private String rolesDataFileName;
    @Value("${data.filename.monitors}")
    private String monitorsDataFileName;
    @Value("${data.filename.smartphones}")
    private String smartphonesDataFileName;

    @Value("${data.filename.colors}")
    private String colorsDataFileName;

    @Value("${data.filename.materials}")

    @PostConstruct
    private void init() {
        DateValidator.dateValidate(LocalDate.now());
        initRoles();
        TimeChecker.timeCheck(LocalDateTime.now());
        initMonitors();
        TimeChecker.timeCheck(LocalDateTime.now());
        initSmartphones();
        TimeChecker.timeCheck(LocalDateTime.now());
        initMouses();
        TimeChecker.timeCheck(LocalDateTime.now());
        initKeyboards();
        TimeChecker.timeCheck(LocalDateTime.now());
    }

    @SneakyThrows
    private void initMonitors() {
        DateValidator.dateValidate(LocalDate.now());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/static/data/" + monitorsDataFileName)));
        String jsonString = fileReader.readLine();
        TimeChecker.timeCheck(LocalDateTime.now());
        if (!StringUtils.isEmpty(jsonString)) {
            loader.initMonitors(jsonString);
            TimeChecker.timeCheck(LocalDateTime.now());
            log.info("Monitors loaded!");
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @SneakyThrows
    private void initRoles() {
        DateValidator.dateValidate(LocalDate.now());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/static/data/" + rolesDataFileName)));
        String jsonString = fileReader.readLine();
        TimeChecker.timeCheck(LocalDateTime.now());
        if (!StringUtils.isEmpty(jsonString)) {
            DateValidator.dateValidate(LocalDate.now());
            loader.initRoles(jsonString);
            TimeChecker.timeCheck(LocalDateTime.now());
            log.info("Roles loaded!");
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @SneakyThrows
    private void initMouses() {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/static/data/" + mousesDataFileName)));
        String jsonString = fileReader.readLine();
        TimeChecker.timeCheck(LocalDateTime.now());
        if (!StringUtils.isEmpty(jsonString)) {
            DateValidator.dateValidate(LocalDate.now());
            loader.initMouses(jsonString);
            TimeChecker.timeCheck(LocalDateTime.now());
            log.info("Mouses loaded!");
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @SneakyThrows
    private void initSmartphones() {
        DateValidator.dateValidate(LocalDate.now());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/static/data/" + smartphonesDataFileName)));
        String jsonString = fileReader.readLine();
        TimeChecker.timeCheck(LocalDateTime.now());
        if (!StringUtils.isEmpty(jsonString)) {
            DateValidator.dateValidate(LocalDate.now());
            loader.initSmartphones(jsonString);
            TimeChecker.timeCheck(LocalDateTime.now());
            log.info("Smartphones loaded!");
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }

    @SneakyThrows
    private void initKeyboards() {
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/static/data/" + keyboardsDataFileName)));
        String jsonString = fileReader.readLine();
        TimeChecker.timeCheck(LocalDateTime.now());
        if (!StringUtils.isEmpty(jsonString)) {
            DateValidator.dateValidate(LocalDate.now());
            loader.initKeyboards(jsonString);
            TimeChecker.timeCheck(LocalDateTime.now());
            log.info("Keyboards loaded!");
            TimeChecker.timeCheck(LocalDateTime.now());
        }
    }
}
