package com.codegym.controller;

import com.codegym.model.Settings;
import com.codegym.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingsController {
    @Autowired
    private ISettingsService settingsService;

    @GetMapping("")
    public String listSettings(Model model) {
        model.addAttribute("settings", settingsService.findAllSettings());
        return "/home";
    }

    @GetMapping("edit/{id}")
    public String showForm(@PathVariable int id, Model model) {
        model.addAttribute("setting", settingsService.findById(id));
        model.addAttribute("languagesList", settingsService.findAllLanguages());
        model.addAttribute("pageSizeList", settingsService.findAllPageSize());
        return "/update";
    }

    @PostMapping("/save")
    public String saveSettings(@ModelAttribute Settings settings, RedirectAttributes redirectAttributes) {
        settingsService.update(settings);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/";
    }
}