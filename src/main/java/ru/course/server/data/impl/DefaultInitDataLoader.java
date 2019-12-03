package ru.course.server.data.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.course.server.daos.*;
import ru.course.server.data.InitDataLoader;
import ru.course.server.models.product.Keyboard;
import ru.course.server.models.product.Monitor;
import ru.course.server.models.product.Mouse;
import ru.course.server.models.product.Smartphone;
import ru.course.server.models.users.Role;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultInitDataLoader implements InitDataLoader {

    private final Gson gson;
    private final RoleRepository roleRepository;
    private final MonitorRepository monitorRepository;
    private final MouseRepository mouseRepository;
    private final SmartphoneRepository smartphoneRepository;
    private final KeyboardRepository keyboardRepository;

    @Override
    public void initRoles(String rolesDataJsonType) {
        if (roleRepository.count() == 0) {
            List<Role> roles = gson.fromJson(rolesDataJsonType, new TypeToken<List<Role>>() {
            }.getType());
            roleRepository.saveAll(roles);
        }
    }

    @Override
    public void initMonitors(String monitorsDataJsonType) {
        if (monitorRepository.count() == 0) {
            monitorRepository.deleteAll();
            List<Monitor> monitors = gson.fromJson(monitorsDataJsonType, new TypeToken<List<Monitor>>() {
            }.getType());
            monitorRepository.saveAll(monitors);
        }
    }

    @Override
    public void initSmartphones(String smartphonesDataJsonType) {
        if (smartphoneRepository.count() == 0) {
            smartphoneRepository.deleteAll();
            List<Smartphone> smartphones = gson.fromJson(smartphonesDataJsonType, new TypeToken<List<Smartphone>>() {
            }.getType());
            smartphoneRepository.saveAll(smartphones);
        }
    }

    @Override
    public void initKeyboards(String keyboardsDataJsonType) {
        if (keyboardRepository.count() == 0) {
            keyboardRepository.deleteAll();
            List<Keyboard> keyboards = gson.fromJson(keyboardsDataJsonType, new TypeToken<List<Keyboard>>() {
            }.getType());
            keyboardRepository.saveAll(keyboards);
        }
    }

    @Override
    public void initMouses(String mousesDataJsonType) {
        if (mouseRepository.count() == 0) {
            mouseRepository.deleteAll();
            List<Mouse> mouses = gson.fromJson(mousesDataJsonType, new TypeToken<List<Mouse>>() {
            }.getType());
            mouseRepository.saveAll(mouses);
        }
    }
}
