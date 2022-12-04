package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;
    private String statusProduct;
    @ManyToOne
    @JoinColumn(name="product_type_id", referencedColumnName = "id")
    private ProductType productType;
    @OneToMany(mappedBy = "product")
    Set<OderProduct> orders;

    public Product() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<OderProduct> getOrders() {
        return orders;
    }

    public void setOrders(Set<OderProduct> orders) {
        this.orders = orders;
    }
}
