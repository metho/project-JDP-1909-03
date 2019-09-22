package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    private long id;
    private String street;
    private String code;
    private String city;
    private User user;

    public Address() {
    }

    public Address(String street, String code, String city) {
        this.street = street;
        this.code = code;
        this.city = city;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    @NotNull
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    @NotNull
    @Column(name = "CODE")
    public String getCode() {
        return code;
    }

    @NotNull
    @Column(name = "CITY")
    public String getCity() {
        return city;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
