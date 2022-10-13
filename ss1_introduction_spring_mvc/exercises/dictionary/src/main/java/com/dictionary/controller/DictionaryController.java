package com.dictionary.controller;

import com.dictionary.service.IDictionaryService;
import com.dictionary.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/dictionary")
    public String showSearchForm(Model model) {
        return "/search";
    }

    @GetMapping("/dictionary/search")
    public String showResult(@RequestParam String word, Model model) {
        String mean = iDictionaryService.findWord(word);
        model.addAttribute("mean", mean);
        return "/search";
    }
}
