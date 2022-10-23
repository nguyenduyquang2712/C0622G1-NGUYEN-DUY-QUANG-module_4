package com.example.excercise2.service;


import com.example.excercise2.model.Bloger;
import com.example.excercise2.repository.BlogerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogerServiceIplm implements IBlogerService {

    @Autowired
    private BlogerRepository blogerRepository ;

    @Override
    public List<Bloger> findAll() {
        return blogerRepository.findAll();
    }

    @Override
    public Bloger findById(int id) {
        return blogerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Bloger bloger) {
        blogerRepository.save(bloger);
    }

    @Override
    public void remove(Bloger bloger) {
        blogerRepository.delete(bloger);
    }

    @Override
    public Page<Bloger> findAllByNameContainingOrderByDateAsc(String blogName, Pageable pageable) {
        return blogerRepository.findAllByNameContainingOrderByDateAsc(blogName, pageable);
    }


    @Override
    public Page<Bloger> findAll(Pageable pageable) {
        return blogerRepository.findAll(pageable);
    }


}
