package com.kodilla.ecommercee.dto;

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
    private long userId;
    private List<ProductDto> products;
}
