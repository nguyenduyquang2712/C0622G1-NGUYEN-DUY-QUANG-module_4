package com.codegym.controller;

import com.codegym.dto.IOderDto;
import com.codegym.model.OderProduct;
import com.codegym.service.IOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;
    @GetMapping("")
    public String showList(@PageableDefault(value = 2) Pageable pageable, Model model){
        Page<IOderDto> oderPage = orderService.showListOrder(pageable);
        model.addAttribute("orderList",oderPage);
        model.addAttribute("products",productService.findAll());
        model.addAttribute("productTypeList",productTypeService.findAll());
        return "order/list";
    }
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") int id, Model model) {
        Optional<OderProduct> oderProduct = orderService.findById(id);
        if(!oderProduct.isPresent()){
            model.addAttribute("message", "cant not update");
            return "order/edit";
        }
        model.addAttribute("products",productService.findAll());
        model.addAttribute("productTypeList",productTypeService.findAll());
        model.addAttribute("order", oderProduct.get());
        return "order/edit";
    }
    @PostMapping("/edit")
    public String editOrder(@ModelAttribute OderProduct oder, Model model) {
    orderService.save(oder);
    model.addAttribute("order", oder);
    model.addAttribute("products",productService.findAll());
    model.addAttribute("productTypeList",productTypeService.findAll());
    model.addAttribute("message","order edit successfully");
    return "order/edit";
    }
}
