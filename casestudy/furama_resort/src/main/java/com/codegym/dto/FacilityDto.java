package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto {
    private Integer id;
    @NotBlank(message = "Tên dịch vụ không được để trống.")
    @Pattern(regexp = "^(([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}( \\d*)?)| *$",
            message = "Tên dịch vụ được phép chứa số, và các kí tự đầu tiên của mỗi từ phải viết hoa.")
    private String name;
    @NotBlank(message = "Diện tích sử dụng không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích sử dụng phải là số nguyên dương.")
    private String area;
    @NotBlank(message = "Chi phí thuê không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Chi phí thuê (VNĐ) phải là số nguyên dương.")
    private String cost;
    @NotBlank(message = "Số người tối đa không được để trống.")
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số người tối đa phải là số nguyên dương.")
    private String maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Diện tích hồ bơi phải là số nguyên dương.")
    private String poolArea;
    @Pattern(regexp = "^[1-9]\\d*| *$", message = "Số tầng phải là số nguyên dương.")
    private String numberOfFloors;
    private String facilityFree;
    private int status = 1;
    private RentType rentType;
    private FacilityType facilityType;
    private Contract contract;

    public FacilityDto() {
    }

    public Integer getId() {
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
