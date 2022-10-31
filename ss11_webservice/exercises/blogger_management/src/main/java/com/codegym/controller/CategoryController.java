package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;


    @GetMapping("/categorys")
    public ModelAndView ShowListBlog() {
        List<Category> categories = categoryService.findAll();

        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView createCategory(@ModelAttribute("category") Category category) {
        Category category1 = category;
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category created compliment");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Category category = categoryService.findById(id);

        if (category == null) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);

        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category updated compliment");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Category category = categoryService.findById(id);

        if (category == null) {
            return new ModelAndView("/error.404");
        }

        ModelAndView modelAndView = new ModelAndView("/category/delete");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category) {
        categoryService.removeById(category.getId());

        return "redirect:categorys";
    }

}