package com.example.excercise2.service;


import com.example.excercise2.model.Bloger;

import java.util.List;

public interface IBlogerService {
    List<Bloger> findAll();

    Bloger findById(int id);

    void save(Bloger bloger);

    void remove(Bloger bloger);

    List<Bloger> findByName(String nameSearch);
}
