package com.example.excercise2.controller;

import com.example.excercise2.model.Bloger;
import com.example.excercise2.model.Category;
import com.example.excercise2.service.IBlogerService;
import com.example.excercise2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blogers")
public class BlogerController {

    @Autowired
    private IBlogerService blogerService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("blog", new Bloger());
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog") Bloger bloger) {
        bloger.setDate(new Date(System.currentTimeMillis()));
        blogerService.save(bloger);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView showBlogList(@PageableDefault(value = 1) Pageable pageable) {
        Page<Bloger> blogers = blogerService.findAll(pageable);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("blogs",blogers);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showUpdateForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        List<Category> categories = categoryService.findAll();
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", bloger);
            modelAndView.addObject("categories", categories);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog") Bloger bloger) {
        bloger.setDate(new Date(System.currentTimeMillis()));
        blogerService.save(bloger);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        List<Category> categories = categoryService.findAll();
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", bloger);
            modelAndView.addObject("categories", categories);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog") Bloger bloger) {
        blogerService.remove(bloger);
        return "redirect:/blogers";
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView view(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);

        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/view");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String nameSearch, @PageableDefault(value = 1) Pageable pageable) {
        Page<Bloger> blogers = blogerService.findAllByNameContainingOrderByDateAsc(nameSearch,pageable);
        List<Category> categories = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("nameSearch",nameSearch);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("blogs", blogers);
        return modelAndView;
    }
}
