package com.example.service;

import com.example.model.Settings;

import java.util.List;

public interface ISettingsService {
    List<String> findAllLanguages();

    List<Integer> findAllPageSize();

    List<Settings> findAllSettings();

    void update(Settings settings);

    Settings findById(int id);
}
