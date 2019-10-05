package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserOrderMapper {

    @Autowired
    private ProductMapper productMapper;

    public UserOrderDto mapToUserOrderDto(final UserOrder userOrder) {
        return new UserOrderDto(
                userOrder.getId(),
                userOrder.getNumber(),
                userOrder.getOrderDate(),
                userOrder.getUser().getId(),
                productMapper.mapToProductDtoList(userOrder.getProducts())
        );
    }
}
