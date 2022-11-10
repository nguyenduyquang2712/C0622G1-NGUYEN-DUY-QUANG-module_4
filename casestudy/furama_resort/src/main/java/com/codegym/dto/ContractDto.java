package com.codegym.dto;

import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import java.util.Set;

public class ContractDto {
    private Integer id;
    @NotBlank(message = "Không được trống")
    private String startDate;
    @NotBlank(message = "Không được trống")
    private String endDate;
    @NotBlank(message = "Không được để trống")
    @PositiveOrZero(message = "Tiền đặt cọc là số không âm")
    private String deposit;
    private int status = 1;
    private Set<ContractDetail> contractDetails;
    @NotNull(message = "Vui lòng chọn")
    private Employee employee;
    @NotNull(message = "Vui lòng chọn")
    private Customer customer;
    @NotNull(message = "Vui lòng chọn")
    private Facility facility;

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public int getStatus() {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
