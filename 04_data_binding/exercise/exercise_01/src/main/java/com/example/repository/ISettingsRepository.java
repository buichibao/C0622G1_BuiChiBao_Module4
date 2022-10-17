package com.example.repository;

import com.example.model.Settings;

import java.util.List;


public interface ISettingsRepository {

    List<String> findAllLanguages();

    List<Integer> findAllPageSize();

    List<Settings> findAllSettings();

    void update(Settings settings);

    Settings findById(int id);
}
