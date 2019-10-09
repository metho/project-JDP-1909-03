package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CartMapper {

    @Autowired
    private ProductMapper productMapper;

    public CartDto toCartDto(final Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        Optional.ofNullable(cart.getUser()).ifPresent(user -> cartDto.setUserId(user.getId()));
        cartDto.setProducts(productMapper.toProductDtoList(cart.getProducts()));
        return cartDto;
    }
}
