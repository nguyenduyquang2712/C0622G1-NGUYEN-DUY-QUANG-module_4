package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.model.ProductType;
import com.codegym.repository.ProductRepository;
import com.codegym.repository.ProductTypeRepository;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }
}
