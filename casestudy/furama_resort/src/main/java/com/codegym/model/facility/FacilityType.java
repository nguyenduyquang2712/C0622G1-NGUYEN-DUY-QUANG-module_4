package com.codegym.model.facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(columnDefinition = "int default 1")
    private int status = 1;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilities;

    public FacilityType() {
    }

    public FacilityType(Integer id, String name, int status, Set<Facility> facilities) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.facilities = facilities;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}