package com.example.web_shop1.model;


import javax.persistence.*;
import java.util.Set;


@Entity
// @Table(name="productInfo")
public class Product {
    // primary key
    @Id
    // let MySQL give the next ID (IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private double price;
    private String description;


    @OneToOne(fetch = FetchType.EAGER)
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Category> categories;


    public Product(){

    }

    public Product(long id, String productName, double price, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
