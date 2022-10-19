package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("products", productList);
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirect) {
        iProductService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Edit product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "product/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "product/view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String searchName, Model model) {
        List<Product> productList = iProductService.findBySearchName(searchName);
        model.addAttribute("products", productList);
        return "product/index";
    }
}
