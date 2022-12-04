package com.codegym.service;

import com.codegym.dto.IOderDto;
import com.codegym.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface IOrderService {
    Page<IOderDto> showListOrder(Pageable pageable);
    Optional<OderProduct> findById(int id);
    void save(OderProduct oderProduct);
}
