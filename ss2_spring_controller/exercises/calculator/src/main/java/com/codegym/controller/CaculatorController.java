package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("/")
    public String showFrom() {
        return "/calculator";
    }

    @GetMapping("/result")
    public String showResult(@RequestParam String submit, double a, double b, Model model) {
        try {
            double result = iCalculatorService.caculate(submit, a, b);
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("result", result);
            return "/calculator";
        } catch (Exception ex) {
            model.addAttribute("a", a);
            model.addAttribute("b", b);
            model.addAttribute("result", "cant not division by zero");
            return "/calculator";
        }

    }
}
