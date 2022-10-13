package com.dictionary.service.impl;

import com.dictionary.model.DictonaryApp;
import com.dictionary.repository.IRepositoryDictionary;
import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IRepositoryDictionary iRepositoryDictionary;
    @Override
    public String findWord(String word) {
        List<DictonaryApp> dictonaryAppList = iRepositoryDictionary.getListDictionary();
        for(DictonaryApp dictonaryApp:dictonaryAppList){
            if(dictonaryApp.getEn().equals(word)){
                return dictonaryApp.getVie();
            }
        }
        return "Not found word";
    }
}
