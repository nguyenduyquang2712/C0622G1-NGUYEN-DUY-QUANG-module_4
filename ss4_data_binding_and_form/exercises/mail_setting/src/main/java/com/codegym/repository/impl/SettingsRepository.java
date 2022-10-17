package com.codegym.repository.impl;

import com.codegym.model.Settings;
import com.codegym.repository.ISettingsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SettingsRepository implements ISettingsRepository {
    private static List<String> languages = new ArrayList<>();
    private static List<Integer> size = new ArrayList<>();
    private static List<Settings> settingsList = new ArrayList<>();
    static{
        languages.add("Vietnamese");
        languages.add("French");
        languages.add("English");
        languages.add("German");

        size.add(5);
        size.add(10);
        size.add(15);
        size.add(20);
        size.add(25);
        size.add(50);
        size.add(100);

        settingsList.add(new Settings(1,"English",25,true,"Quang,Liverpool"));
        settingsList.add(new Settings(2,"Vietnamese",5,false,"Huy,MNSD"));
        settingsList.add(new Settings(3,"French",50,true,"Giang,Mersersiders"));
        settingsList.add(new Settings(4,"German",100,false,"Linh,Chelsea"));

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
        for(Settings setting : settingsList){
            if(settings.getId()==setting.getId()){
                setting.setLanguages(settings.getLanguages());
                setting.setPageSize(settings.getPageSize());
                setting.setSignature(settings.getSignature());
                setting.setSpamsFilter(settings.isSpamsFilter());
                return;
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
