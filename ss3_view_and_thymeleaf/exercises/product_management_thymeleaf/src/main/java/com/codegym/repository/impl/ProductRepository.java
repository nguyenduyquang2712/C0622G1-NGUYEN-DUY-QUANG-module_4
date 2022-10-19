package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Iphone14", 2000, "Bán chạy"));
        products.put(2, new Product(2, "laptop Dell", 20000, "Hết hàng"));
        products.put(3, new Product(3, "Iphone12", 15500, "Thảm họa"));
        products.put(4, new Product(4, "Iphone 13", 12000, "Bán chạy"));
        products.put(6, new Product(6, "Laptop Asus", 10000, "Thảm họa"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public List<Product> findBySearchName(String searchName) {
        List<Product> products = new ArrayList<>();
        for (Product product : findAll()) {
            if (product.getName().equals(searchName)) {
                products.add(product);
            }
        }
        return products;
    }
}
