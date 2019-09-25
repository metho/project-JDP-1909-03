package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
    private long id;
    private String number;
    private LocalDate orderDate;
    private User user;
    private List<Product> products;
}
