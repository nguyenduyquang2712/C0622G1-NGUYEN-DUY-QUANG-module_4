package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void remove(Product product);

    void update(Product product);

    List<Product> findBySearchName(String searchName);
}
