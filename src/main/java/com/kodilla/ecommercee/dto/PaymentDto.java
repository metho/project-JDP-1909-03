package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;
    private Long userOrderId;
    private BigDecimal price;
    private boolean paymentStatus;

    public PaymentDto(Long id, BigDecimal price, boolean paymentStatus) {
        this.id = id;
        this.price = price;
        this.paymentStatus = paymentStatus;
    }
}
