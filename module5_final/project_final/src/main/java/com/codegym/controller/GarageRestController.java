package com.codegym.controller;

import com.codegym.model.Garage;
import com.codegym.service.IGarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/garage")
@CrossOrigin("*")
public class GarageRestController {
    @Autowired
    private IGarageService garageService;
    @GetMapping
    public ResponseEntity<List<Garage>> showAllGarage() {
        List<Garage> garageList = garageService.findAll();
        if (garageList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(garageList,HttpStatus.OK);
    }

}
