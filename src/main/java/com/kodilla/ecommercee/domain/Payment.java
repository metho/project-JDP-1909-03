package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "PAYMENT_ID")
    private Long id;

    @OneToOne
    @JoinColumn(name = "ORDER_ID")
    private UserOrder userOrder;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    @NotNull
    @Column(name = "STATUS_PAYMENT")
    private boolean paymentStatus;

    public Payment(Long id, BigDecimal price, boolean paymentStatus) {
        this.id = id;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }
}
