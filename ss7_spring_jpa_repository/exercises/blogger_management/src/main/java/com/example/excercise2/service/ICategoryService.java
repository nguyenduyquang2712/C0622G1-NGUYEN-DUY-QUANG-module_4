package com.example.excercise2.service;

import com.example.excercise2.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(Category category);
}
