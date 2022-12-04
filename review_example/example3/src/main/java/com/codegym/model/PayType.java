package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PayType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "payType")
    Set<RestRoom> restRooms;

    public PayType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RestRoom> getRestRooms() {
        return restRooms;
    }

    public void setRestRooms(Set<RestRoom> restRooms) {
        this.restRooms = restRooms;
    }
}
