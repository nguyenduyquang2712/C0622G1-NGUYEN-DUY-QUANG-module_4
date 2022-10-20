package com.example.excercise2.controller;

import com.example.excercise2.model.Bloger;
import com.example.excercise2.service.IBlogerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogerController {

    @Autowired
    private IBlogerService blogerService;

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Bloger());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView createBlog(@ModelAttribute("blog")Bloger bloger) {
        blogerService.save(bloger);

        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Blog created successfully");
        return modelAndView;
    }

    @GetMapping("/blogers")
    public ModelAndView showBlogList() {
        List<Bloger> blogers = blogerService.findAll();

        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("blogs", blogers);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
        public ModelAndView showUpdateForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/edit");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView update(@ModelAttribute("blog")Bloger bloger) {
        blogerService.save(bloger);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", bloger);
        modelAndView.addObject("message", "Updated blog successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Bloger bloger = blogerService.findById(id);
        if (bloger != null) {
            ModelAndView modelAndView = new ModelAndView("blog/delete");
            modelAndView.addObject("blog", bloger);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String delete(@ModelAttribute("blog")Bloger bloger) {
        blogerService.remove(bloger);
        return "redirect:blogers";
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
    public ModelAndView search(@RequestParam String nameSearch){
        List<Bloger> blogers = blogerService.findByName(nameSearch);

        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("blogs", blogers);
        return modelAndView;
    }
}
