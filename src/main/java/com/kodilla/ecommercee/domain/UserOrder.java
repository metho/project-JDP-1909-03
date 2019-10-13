package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;

    @NotNull
    @Column(name = "NUMBER")
    private String number;

    @NotNull
    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @NotNull
    @Column(name = "MAIL_SENT")
    private boolean mailSent;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(mappedBy = "userOrders")
    private List<Product> products = new ArrayList<>();

    public UserOrder(String number, User user) {
        this.number = number;
        this.orderDate = LocalDate.now();
        this.user = user;
    }
}
