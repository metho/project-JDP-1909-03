package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    private long id;
    private String name;
    private String surname;
    private Address address;
    private List<UserOrder> userOrders = new ArrayList<>();
    private Cart cart;

    public User() {
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @NotNull
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    @OneToMany(
            targetEntity = UserOrder.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
