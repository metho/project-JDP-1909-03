package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserOrderMapper {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductRepository productRepository;

    public UserOrderDto toUserOrderDto(final UserOrder userOrder) {
        UserOrderDto userOrderDto = new UserOrderDto();
        userOrderDto.setId(userOrder.getId());
        userOrderDto.setNumber(userOrder.getNumber());
        userOrderDto.setOrderDate(userOrder.getOrderDate());
        userOrderDto.setUserDto(userMapper.toUserDto(userOrder.getUser()));
        userOrder.setMailSent(userOrder.isMailSent());

        if (userOrder.getProducts() != null) {
            userOrderDto.setProducts(productMapper.toProductDtoList(userOrder.getProducts()));
        }
        return userOrderDto;
    }

    public UserOrder toUserOrder(final UserOrderDto userOrderDto) {
        UserOrder userOrder = new UserOrder();
        userOrder.setId(userOrderDto.getId());
        userOrder.setNumber(userOrderDto.getNumber());
        userOrder.setOrderDate(userOrderDto.getOrderDate());
        userOrder.setUser(userMapper.toUser(userOrderDto.getUserDto()));
        userOrder.setMailSent(userOrderDto.isMailSent());
        if (userOrderDto.getProducts() != null) {
            for (ProductDto productDto : userOrderDto.getProducts()) {
                Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", String.valueOf(productDto.getId())));
                product.getUserOrders().add(userOrder);
                userOrder.getProducts().add(product);
            }
        }
        return userOrder;
    }

    public List<UserOrderDto> toUserOrderDtoList(final List<UserOrder> userOrderList) {
        return userOrderList.stream()
                .map(this::toUserOrderDto)
                .collect(Collectors.toList());
    }
}
