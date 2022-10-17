package com.codegym.service.impl;

import com.codegym.model.Settings;
import com.codegym.repository.ISettingsRepository;
import com.codegym.repository.impl.SettingsRepository;
import com.codegym.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SettingsService implements ISettingsService {
    @Autowired
    ISettingsRepository iSettingsRepository;
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
