package com.example.repository.impl;

import com.example.model.Settings;
import com.example.repository.ISettingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingsRepository implements ISettingsRepository {
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> size = new ArrayList<>();
    private static List<Settings> settingsList = new ArrayList<>();

    static {

        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        size.add(5);
        size.add(10);
        size.add(15);
        size.add(25);
        size.add(50);
        size.add(100);

        settingsList.add(new Settings(1,"English",25,true,"ABC"));
        settingsList.add(new Settings(2,"Vietnamese",5,false,"ABC"));
        settingsList.add(new Settings(3,"Japanese",50,true,"ABC"));
        settingsList.add(new Settings(4,"Chinese",100,false,"ABC"));

    }

    @Override
    public List<String> findAllLanguages() {
        return languages;
    }

    @Override
    public List<Integer> findAllPageSize() {
        return size;
    }

    @Override
    public List<Settings> findAllSettings() {
        return settingsList;
    }


    @Override
    public void update(Settings settings) {
        for (Settings s:settingsList) {
            if ((s.getId())==(settings.getId())){
                settingsList.remove(s);
                settingsList.add(settings);
                break;
            }
        }
    }

    @Override
    public Settings findById(int id) {
        for (Settings settings:settingsList) {
            if(settings.getId()==id){
                return settings;
            }
        }
        return null;
    }
}
