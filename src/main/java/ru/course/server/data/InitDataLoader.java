package ru.course.server.data;

public interface InitDataLoader {
    void initRoles(String rolesDataJsonType);

    void initMonitors(String monitorsDataJsonType);

    void initSmartphones(String smartphonesDataJsonType);

    void initKeyboards(String keyboardsDataJsonType);

    void initMouses(String mousesDataJsonType);
}
