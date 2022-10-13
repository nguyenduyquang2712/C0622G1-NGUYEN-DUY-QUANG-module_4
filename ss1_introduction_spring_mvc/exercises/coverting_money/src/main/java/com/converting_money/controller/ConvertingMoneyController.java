package com.converting_money.controller;

import com.converting_money.service.IConverting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ConvertingMoneyController {
    @Autowired
    IConverting iConverting;
    @GetMapping("/")
    public String showConvertingForm(){
        return "/formconverting";
    }
    @PostMapping("/")
    public String showResult(@RequestParam double usd, Model model) {
        if (usd >0) {
            double vnd = iConverting.convert(usd);
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
            return "/formconverting";
        } else {
            model.addAttribute("usd", "gia tri ko hop le");
            return "/formconverting";
        }
    }
}
