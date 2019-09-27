package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ProductGroup {

    @Column(name = "NAME")
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @OneToMany(mappedBy = "productGroup")
    private List<Product> products = new ArrayList<>();

    public ProductGroup(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
