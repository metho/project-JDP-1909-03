package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @NotNull
    @Column(name = "STREET")
    private String street;

    @NotNull
    @Column(name = "CODE")
    private String code;

    @NotNull
    @Column(name = "CITY")
    private String city;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Address(String street, String code, String city) {
        this.street = street;
        this.code = code;
        this.city = city;
    }
}
