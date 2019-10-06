package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.UserOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserOrderMapper {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

    public UserOrderDto mapToUserOrderDto(final UserOrder userOrder) {
        UserOrderDto userOrderDto = new UserOrderDto();
        userOrderDto.setId(userOrder.getId());
        userOrderDto.setNumber(userOrder.getNumber());
        userOrderDto.setOrderDate(userOrder.getOrderDate());
        userOrderDto.setUserDto(userMapper.mapToUserDto(userOrder.getUser()));
        if (userOrder.getProducts() != null) {
            userOrderDto.setProducts(productMapper.mapToProductDtoList(userOrder.getProducts()));
        }
        return userOrderDto;
    }

    public UserOrder mapToUserOrder(final UserOrderDto userOrderDto) {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(userOrderDto.getId());
        userOrder.setNumber(userOrderDto.getNumber());
        userOrder.setOrderDate(userOrderDto.getOrderDate());
        userOrder.setUser(userMapper.mapToUser(userOrderDto.getUserDto()));

        return userOrder;
    }

    public List<UserOrderDto> mapToUserOrderDtoList(final List<UserOrder> userOrderList) {
        return userOrderList.stream()
                .map(this::mapToUserOrderDto)
                .collect(Collectors.toList());
    }
}