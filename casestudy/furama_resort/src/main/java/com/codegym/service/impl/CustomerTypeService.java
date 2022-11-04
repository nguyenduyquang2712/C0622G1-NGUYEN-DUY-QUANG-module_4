package com.codegym.service.impl;

import com.codegym.model.customer.CustomerType;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.CustomerTypeRepository;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
