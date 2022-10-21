package com.example.excercise2.service;


import com.example.excercise2.model.Bloger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IBlogerService {
    List<Bloger> findAll();

    Bloger findById(int id);

    void save(Bloger bloger);

    void remove(Bloger bloger);

    List<Bloger> findByName(String nameSearch);

    Page<Bloger> findAll(Pageable pageable);

}
