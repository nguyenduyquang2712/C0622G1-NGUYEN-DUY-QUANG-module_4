package com.codegym.service.impl;

import com.codegym.model.Garage;
import com.codegym.repository.GarageRepository;
import com.codegym.service.IGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService implements IGarageService {
    @Autowired
    private GarageRepository garageRepository;
    @Override
    public List<Garage> findAll() {
        return garageRepository.findAll();
    }
}
