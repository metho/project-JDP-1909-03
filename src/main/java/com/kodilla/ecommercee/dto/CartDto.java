package com.kodilla.ecommercee.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private long id;
    private long userId;
    private List<ProductDto> products;
}
