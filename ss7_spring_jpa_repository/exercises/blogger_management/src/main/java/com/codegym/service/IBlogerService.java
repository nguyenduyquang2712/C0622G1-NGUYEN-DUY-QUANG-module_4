package com.codegym.service;


import com.codegym.model.Bloger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogerService {
    List<Bloger> findAll();

    Bloger findById(int id);

    void save(Bloger bloger);

    void remove(Bloger bloger);

    Page<Bloger> findAllByNameContainingOrderByDateDesc(String blogName, Pageable pageable);

    Page<Bloger> findAll(Pageable pageable);

}
