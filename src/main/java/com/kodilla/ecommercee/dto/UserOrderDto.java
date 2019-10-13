package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDto {
    private long id;
    private String number;
    private LocalDate orderDate;
    private UserDto userDto;
    private boolean mailSent;
    private List<ProductDto> products;
}
