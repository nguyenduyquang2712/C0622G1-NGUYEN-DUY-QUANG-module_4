package com.codegym.controller;


import com.codegym.dto.FacilityDto;
import com.codegym.model.facility.Facility;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import com.codegym.service.IFacilityService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public ModelAndView showFacilities(@RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
                                       @RequestParam(value = "facilityType", defaultValue = "") String facilityType,
                                       @PageableDefault(value = 3) Pageable pageable) {
        Page<Facility> facilities = facilityService.findAllByNameAndType(nameSearch, facilityType, pageable);
        List<FacilityType> facilityTypeList = facilityService.findAllFacilityType();
        List<RentType> rentTypeList = facilityService.findAllRentType();
        ModelAndView modelAndView = new ModelAndView("facility/list");
        modelAndView.addObject("facilities", facilities);
        modelAndView.addObject("facilityTypeList", facilityTypeList);
        modelAndView.addObject("rentTypeList", rentTypeList);
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("facilityType", facilityType);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("RentTypeList", facilityService.findAllRentType());
        modelAndView.addObject("facilityTypeList",facilityService.findAllFacilityType());
        modelAndView.addObject("facilityDto", new FacilityDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("facility/create");
            modelAndView.addObject("RentTypeList", facilityService.findAllRentType());
            modelAndView.addObject("facilityTypeList", facilityService.findAllFacilityType());
            modelAndView.addObject("facilityTypeId", facilityDto.getFacilityType().getId());
            modelAndView.addObject("facilityDto", facilityDto);
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("facility/create");
        modelAndView.addObject("RentTypeList", facilityService.findAllRentType());
        modelAndView.addObject("facilityTypeList", facilityService.findAllFacilityType());
        modelAndView.addObject("facilityTypeId", facilityDto.getFacilityType().getId());
        modelAndView.addObject("facilityDto", facilityDto);
        modelAndView.addObject("message", "Add new Successful");
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String deleteFacility(@RequestParam(value = "idDelete") int id, RedirectAttributes redirectAttributes){
        facilityService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete facility successfully!");
        return "redirect:/facilities";
    }
}
