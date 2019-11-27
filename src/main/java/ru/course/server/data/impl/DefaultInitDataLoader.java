package ru.course.server.data.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.course.server.daos.ColorRepository;
import ru.course.server.daos.MaterialRepository;
import ru.course.server.daos.RoleRepository;
import ru.course.server.data.InitDataLoader;
import ru.course.server.models.product.commons.Color;
import ru.course.server.models.product.commons.Material;
import ru.course.server.models.users.Role;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultInitDataLoader implements InitDataLoader {

    private final Gson gson;
    private final ColorRepository colorRepository;
    private final MaterialRepository materialRepository;
    private final RoleRepository roleRepository;

    @Override
    public void initColors(String colorsDataJsonType) {
        if(colorRepository.count() == 0) {
            List<Color> colors = gson.fromJson(colorsDataJsonType, new TypeToken<List<Color>>() {
            }.getType());
            colorRepository.saveAll(colors);
        }
    }

    @Override
    public void initMaterials(String materialsDataJsonType) {
        if(materialRepository.count() == 0) {
            List<Material> materials = gson.fromJson(materialsDataJsonType, new TypeToken<List<Material>>() {
            }.getType());
            materialRepository.saveAll(materials);
        }
    }

    @Override
    public void initRoles(String rolesDataJsonType) {
        if(roleRepository.count() == 0) {
            List<Role> roles = gson.fromJson(rolesDataJsonType, new TypeToken<List<Role>>() {
            }.getType());
            roleRepository.saveAll(roles);
        }
    }
}
