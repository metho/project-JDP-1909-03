package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    private long id;
    private User user;
    private List<Product> products = new ArrayList<>();

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID")
    public long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    @ManyToMany(mappedBy = "carts")
    public List<Product> getProducts() {
        return products;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}