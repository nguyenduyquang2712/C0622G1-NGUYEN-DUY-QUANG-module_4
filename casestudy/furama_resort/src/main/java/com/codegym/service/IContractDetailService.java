package com.codegym.service;

import com.codegym.dto.IContractDetailDto;
import com.codegym.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);

    List<IContractDetailDto> showAll(Integer id);
}
