package com.codegym.service.impl;

import com.codegym.dto.IOderDto;
import com.codegym.model.OderProduct;
import com.codegym.repository.OrderRepository;
import com.codegym.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class OderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Page<IOderDto> showListOrder(Pageable pageable) {
        return orderRepository.showListOrder(pageable);
    }

    @Override
    public Optional<OderProduct> findById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(OderProduct oderProduct) {
        orderRepository.save(oderProduct);
    }
}
