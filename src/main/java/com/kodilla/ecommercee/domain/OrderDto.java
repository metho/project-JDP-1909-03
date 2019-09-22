package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

public class OrderDto {
    private Long id;
    private String name;
    private LocalDate localDate;
    private String content;
    private String status;
    private String address;
    private String city;
    private String zip;
    private double totalPrice;
}
