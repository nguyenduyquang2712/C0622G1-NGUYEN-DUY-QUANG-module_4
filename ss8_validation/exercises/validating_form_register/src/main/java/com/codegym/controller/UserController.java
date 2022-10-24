package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("users/form");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView accept(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("users/form");
            return modelAndView;
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            ModelAndView modelAndView = new ModelAndView("users/result");
            return modelAndView;
        }
    }
}
