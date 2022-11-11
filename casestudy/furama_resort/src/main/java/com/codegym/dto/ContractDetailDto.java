package com.codegym.dto;


import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {
    private Integer id;
    @NotNull(message = "Không để trống")
    @Min(1)
    private Integer quantity;
    private int status = 1;
    private AttachFacility attachFacility;
    private Contract contract;

    public ContractDetailDto() {
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
