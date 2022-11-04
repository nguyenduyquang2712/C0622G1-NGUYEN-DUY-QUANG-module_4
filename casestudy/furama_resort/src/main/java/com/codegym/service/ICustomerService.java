package com.codegym.service;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    void remove(int id);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findByNameAndEmailAndCustomerType(String name, String email,String type,Pageable pageable);
}
