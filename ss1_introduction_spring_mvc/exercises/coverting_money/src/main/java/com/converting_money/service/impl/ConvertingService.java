package com.converting_money.service.impl;

import com.converting_money.service.IConverting;
import org.springframework.stereotype.Service;

@Service
public class ConvertingService implements IConverting{
    @Override
    public double convert(double usd) {
        return usd*23000;
    }
}
