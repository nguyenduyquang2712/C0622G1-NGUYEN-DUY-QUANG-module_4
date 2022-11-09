package com.codegym.controller;

import com.codegym.dto.IContractDetailDto;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contracts/v1")
@CrossOrigin("*")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("/{id}")
    public ResponseEntity<List<IContractDetailDto>> showAll(@PathVariable int id) {
        List<IContractDetailDto> list = iContractDetailService.showAll(id);
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
