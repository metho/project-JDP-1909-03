package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.UserOrderDto;
import org.springframework.stereotype.Component;

@Component
public class UserOrderMapper {

    public UserOrderDto mapToUserOrderDto(final UserOrder userOrder) {
        return new UserOrderDto();
    }
}
