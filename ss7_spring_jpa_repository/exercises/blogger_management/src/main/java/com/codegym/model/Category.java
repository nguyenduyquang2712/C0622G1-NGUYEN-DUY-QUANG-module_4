package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    private Set<Bloger> blogers;

    public Category() {
    }

    public Category(int id, String name, Set<Bloger> blogers) {
        this.id = id;
        this.name = name;
        this.blogers = blogers;
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

    public Set<Bloger> getBlogers() {
        return blogers;
    }

    public void setBlogers(Set<Bloger> blogers) {
        this.blogers = blogers;
    }
}
