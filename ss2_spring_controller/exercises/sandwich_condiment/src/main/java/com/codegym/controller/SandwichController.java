package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/")
    public String showFrom() {
        return "/result";
    }
    @RequestMapping("/result")
    public String showResult(@RequestParam("condiment") String[] condiment , Model model) {
        model.addAttribute("condiment", condiment);
        return "/result";
    }
}
