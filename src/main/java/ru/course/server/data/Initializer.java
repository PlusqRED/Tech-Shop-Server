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

    @PostConstruct
    private void init() {
        initColors();
        initMaterials();
        initRoles();
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
    private void initMaterials() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + materialsDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initMaterials(jsonString);
            log.info("Materials loaded!");
        }
    }

    @SneakyThrows
    private void initColors() {
        File dataFile = new File(getClass().getClassLoader().getResource("static/data/" + colorsDataFileName).toURI());
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));
        String jsonString = fileReader.readLine();
        if (!StringUtils.isEmpty(jsonString)) {
            initDataLoader.initColors(jsonString);
            log.info("Colors loaded!");
        }
    }
}
