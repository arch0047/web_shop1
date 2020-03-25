package com.example.web_shop1.model;


import javax.persistence.*;

@Entity
public class CompanyProDesc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    //mappedBy is another entity name for this class.
    @OneToOne(fetch = FetchType.EAGER)
    private  Product product;

    public CompanyProDesc() {}

    public CompanyProDesc(int id, String description, Product product) {

        this.id = id;
        this.description = description;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
