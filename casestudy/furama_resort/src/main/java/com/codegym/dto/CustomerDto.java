package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Set;

public class CustomerDto {
    private int id;
    @NotBlank(message = "Name không được để trống")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5})| *$",
            message = "Tên khách hàng không được chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;
    @NotBlank(message="Không được để trống")
    private String dateOfBirth;
    private int gender;
    @NotBlank(message = "Số CMND/CCCD không được để trống.")
    @Pattern(regexp = "^(\\d{9}|\\d{12})| *$",
            message = "Số CMND/CCCD phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9).")
    private String idCard;
    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^((0|[(]84[)][+])9[01]\\d{7})| *$", message =
            "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @NotBlank(message = "Email không được để trống.")
    @Email(message = "Địa chỉ email phải đúng định dạng.")
    private String email;
    @NotBlank(message = "Địa chỉ không được để trống.")
    private String address;
    private Integer status = 1;
    private CustomerType customerType;
    private Set<Contract> contracts;
    public CustomerDto() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
