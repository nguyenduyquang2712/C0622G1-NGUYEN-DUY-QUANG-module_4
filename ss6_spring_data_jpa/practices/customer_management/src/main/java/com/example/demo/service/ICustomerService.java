package com.example.demo.service;


import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService  {

    void save(Customer customer);

    List<Customer> findAll();

   Customer findById(int id);

    void remove(Customer customer);
}

