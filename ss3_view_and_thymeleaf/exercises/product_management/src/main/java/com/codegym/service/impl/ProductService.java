package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void remove(Product product) {
//      Product product1 = iProductRepository.findById(product.getId());
        iProductRepository.remove(product);
    }

    @Override
    public void update( Product product) {
        iProductRepository.update(product);
    }

    @Override
    public List<Product> findBySearchName(String searchName) {
        return iProductRepository.findBySearchName(searchName);
    }
}
