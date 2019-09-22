package com.kodilla.ecommercee.domain;

import javax.persistence.*;

public class Cart {

    private long id;
    private User user;

    public Cart() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
