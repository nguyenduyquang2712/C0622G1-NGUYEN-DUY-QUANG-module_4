package com.example.excercise2.service;

import com.example.excercise2.model.Category;
import com.example.excercise2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return  categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(new Category());
    }

    @Override
    public void save(Category category) {
            categoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
          categoryRepository.delete(category);
    }
}
