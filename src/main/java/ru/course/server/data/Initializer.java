package ru.course.server.data;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
@Log
@PropertySource("classpath:properties/local.properties")
public class Initializer {

    private final InitDataLoader initDataLoader;
    @Value("${data.filename.colors}")
    private String colorsDataFileName;
    @Value("${data.filename.materials}")
    private String materialsDataFileName;
    @Value("${data.filename.roles}")
    private String rolesDataFileName;
    @Value("${data.filename.monitors}")
    private String monitorsDataFileName;
    @Value("${data.filename.mouses}")
    private String mousesDataFileName;
    @Value("${data.filename.keyboards}")
    private String keyboardsDataFileName;
    @Value("${data.filename.smartphones}")
    private String smartphonesDataFileName;

    @PostConstruct
    private void init() {
        initRoles();
        initMonitors();
        initSmartphones();
        initMouses();
        initKeyboards();
    }

    @SneakyThrows
    private void initMonitors() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + monitorsDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initMonitors(jsonString);
            log.info("Monitors loaded!");
        }
    }

    @SneakyThrows
    private void initRoles() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + rolesDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initRoles(jsonString);
            log.info("Roles loaded!");
        }
    }

    @SneakyThrows
    private void initMouses() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + mousesDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initMouses(jsonString);
            log.info("Mouses loaded!");
        }
    }

    @SneakyThrows
    private void initSmartphones() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + smartphonesDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initSmartphones(jsonString);
            log.info("Smartphones loaded!");
        }
    }

    @SneakyThrows
    private void initKeyboards() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + keyboardsDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initKeyboards(jsonString);
            log.info("Keyboards loaded!");
        }
    }
}
