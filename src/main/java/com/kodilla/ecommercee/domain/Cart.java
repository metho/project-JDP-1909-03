package com.kodilla.ecommercee.domain;

import javax.persistence.*;

@Entity
public class Cart {

    private long id;
    private User user;

    public Cart() {
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
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
