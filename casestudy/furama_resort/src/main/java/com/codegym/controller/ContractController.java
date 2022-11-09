package com.codegym.controller;

import com.codegym.dto.IContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        modelAndView.addObject("contract", new Contract());
        modelAndView.addObject("contractDetail",new ContractDetail());
        return modelAndView;
    }

    @PostMapping("/add")
    public String saveContract(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng thành công!");

        return "redirect:/contracts";
    }

    @PostMapping("/add-contract-detail")
    public String saveDetail(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Thêm mới hợp đồng chi tiết thành công!");

        return "redirect:/contracts";
    }

    @GetMapping("/{id}")
    public String showAttachFacility(@PathVariable Integer id, Model model) {
        model.addAttribute("contractDetails", contractDetailService.showAll(id));

        return "contract/attachFacilityList";
    }
}
