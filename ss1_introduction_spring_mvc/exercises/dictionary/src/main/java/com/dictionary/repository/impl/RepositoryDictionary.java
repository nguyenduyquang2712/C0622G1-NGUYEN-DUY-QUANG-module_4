package com.dictionary.repository.impl;


import com.dictionary.model.DictonaryApp;
import com.dictionary.repository.IRepositoryDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryDictionary implements IRepositoryDictionary {
  private static List<DictonaryApp> dictonaryAppList = new ArrayList<>();
   static {
       dictonaryAppList.add(new DictonaryApp("book","quyển sách"));
       dictonaryAppList.add(new DictonaryApp("note","ghi chú"));
       dictonaryAppList.add(new DictonaryApp("pen","cây viết"));
       dictonaryAppList.add(new DictonaryApp("apple","quả táo"));
       dictonaryAppList.add(new DictonaryApp("orange","quả cam"));
   }


    @Override
    public List<DictonaryApp> getListDictionary() {
        return dictonaryAppList;
    }
}
