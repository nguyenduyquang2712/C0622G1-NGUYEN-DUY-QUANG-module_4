package com.codegym.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Double cost;
    private String unit;
    private String serviceStatus;
    @Column(columnDefinition = "int default 1")
    private int status = 1;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public AttachFacility(Integer id, String name, Double cost, String unit, String serviceStatus, int status, Set<ContractDetail> contractDetails) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.serviceStatus = serviceStatus;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}