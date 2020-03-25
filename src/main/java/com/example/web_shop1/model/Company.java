package com.example.web_shop1.model;

import javax.persistence.*;


//name of vendor
//company has a one to many relation to product
//the webshop may sell many product from the same company
//a product comes from one and only one company

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Product product;
    private String companyName;


    public Company() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}





