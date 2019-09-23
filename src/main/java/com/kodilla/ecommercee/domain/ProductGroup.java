package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductGroup {
    private String name;
    private long id;
    private List<Product> products = new ArrayList<>();

    public ProductGroup() {
    }

    public ProductGroup(String name) {
        this.name = name;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "productGroup",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
