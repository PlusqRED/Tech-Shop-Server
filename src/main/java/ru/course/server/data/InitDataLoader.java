package ru.course.server.data;

public interface InitDataLoader {
    void initColors(String colorsDataJsonType);

    void initMaterials(String materialsDataJsonType);

    void initRoles(String rolesDataJsonType);
}
