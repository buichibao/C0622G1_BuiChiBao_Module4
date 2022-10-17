package com.example.service.impl;

import com.example.model.Settings;
import com.example.repository.ISettingsRepository;
import com.example.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SettingsService implements ISettingsService {

    @Autowired
    private ISettingsRepository iSettingsRepository;
    @Override
    public List<String> findAllLanguages() {
        return iSettingsRepository.findAllLanguages();
    }

    @Override
    public List<Integer> findAllPageSize() {
        return iSettingsRepository.findAllPageSize();
    }

    @Override
    public List<Settings> findAllSettings() {
        return iSettingsRepository.findAllSettings();
    }

    @Override
    public void update(Settings settings) {
        iSettingsRepository.update(settings);
    }

    @Override
    public Settings findById(int id) {
        return iSettingsRepository.findById(id);
    }
}
