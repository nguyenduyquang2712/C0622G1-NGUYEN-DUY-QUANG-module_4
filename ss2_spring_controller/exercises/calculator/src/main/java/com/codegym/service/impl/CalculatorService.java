package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double caculate(String submit, double a, double b) {
        switch (submit) {
            case "add":
                return a + b;
            case "sub":
                return a - b;
            case"multiple":
                return a * b;
            case"division":
                if(b!=0){
                return a / b;}
                else {
                    throw new RuntimeException("Can't divide by zero");
                }
        }
        return 0;
    }
}
