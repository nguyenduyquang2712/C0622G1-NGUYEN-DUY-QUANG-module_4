package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/create")
    public ModelAndView creatCustomer() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView acceptCreateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("customer/create");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            ModelAndView modelAndView = new ModelAndView("customer/create");
            modelAndView.addObject("customerTypeList", customerTypeList);
            modelAndView.addObject("customerDto", customerDto);
            modelAndView.addObject("message", "New customer created successfully");
            return modelAndView;
        }
    }

    @GetMapping("")
    public ModelAndView showCustomers(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                      @RequestParam(value = "email", defaultValue = "") String email, @RequestParam(value = "customerType", defaultValue = "") String customerType, @PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findByNameAndEmailAndCustomerType(nameSearch, email, customerType, pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerTypeList", customerTypeList);
        return modelAndView;
    }

}
