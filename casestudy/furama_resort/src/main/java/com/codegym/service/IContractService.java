package com.codegym.service;

import com.codegym.dto.IContractDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDto> showListConTract(Pageable pageable);
    void save(Contract contract);
    List<Contract> findAll();
    List<AttachFacility> findAllAttachFacility();

}
