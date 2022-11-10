package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.dto.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("")
    public ModelAndView showContracts(@PageableDefault(value = 3) Pageable pageable){
        Page<IContractDto>  contractPage = contractService.showListConTract(pageable);
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contractList", contractPage);
        modelAndView.addObject("attachFacilityList",contractService.findAllAttachFacility());
        modelAndView.addObject("contractDetailList",contractDetailService.findAll());
        modelAndView.addObject("facilityList",facilityService.findAll());
        modelAndView.addObject("employeeList",employeeService.findAll());
        modelAndView.addObject("customerList",customerService.findAll());
        modelAndView.addObject("contractDto", new ContractDto());
        modelAndView.addObject("contractDetailDto",new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/add")
    public String saveContract(Model model,@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult,@PageableDefault(value = 3) Pageable pageable,RedirectAttributes redirectAttributes) {
       if(bindingResult.hasFieldErrors()){
           model.addAttribute("contractList",contractService.showListConTract(pageable));
           model.addAttribute("attachFacilityList",contractService.findAllAttachFacility());
           model.addAttribute("contractDetailList",contractDetailService.findAll());
           model.addAttribute("facilityList",facilityService.findAll());
           model.addAttribute("employeeList",employeeService.findAll());
           model.addAttribute("customerList",customerService.findAll());
           model.addAttribute("contractDetailDto",new ContractDetailDto());
           model.addAttribute("contractDto",contractDto);
           return "contract/list";
       }
       Contract contract = new Contract();
       BeanUtils.copyProperties(contractDto,contract);
       contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng thành công!");
        return "redirect:/contracts";
    }

    @PostMapping("/add-contract-detail")
    public String saveDetail(@ModelAttribute @Validated ContractDetailDto contractDetailDto,BindingResult bindingResult,@PageableDefault(value = 3) Pageable pageable,Model model, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contractList",contractService.showListConTract(pageable));
            model.addAttribute("attachFacilityList",contractService.findAllAttachFacility());
            model.addAttribute("contractDetailList",contractDetailService.findAll());
            model.addAttribute("facilityList",facilityService.findAll());
            model.addAttribute("employeeList",employeeService.findAll());
            model.addAttribute("customerList",customerService.findAll());
            model.addAttribute("contractDetailDto",contractDetailDto);
            model.addAttribute("contractDto", new ContractDto());
            return "contract/list";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");
        return "redirect:/contracts";
    }

}

