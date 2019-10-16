package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.mapper.UserOrderMapper;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserOrderService {
    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserOrderMapper userOrderMapper;

    public List<UserOrderDto> getAllOrder() {
        return userOrderMapper.toUserOrderDtoList(userOrderRepository.findAll());
    }

    public UserOrderDto getOrder(final Long userOrderId) throws EntityNotFoundException {
        return userOrderMapper.toUserOrderDto(userOrderRepository.findById(userOrderId)
                .orElseThrow(() -> new EntityNotFoundException(UserOrder.class, "id", userOrderId.toString()))
        );
    }

    public UserOrderDto createOrder(final UserOrderDto userOrderDto) {
        return userOrderMapper.toUserOrderDto(userOrderRepository.save(userOrderMapper.toUserOrder(userOrderDto)));
    }

    public void deleteOrder(Long userOrderId) {
        userOrderRepository.deleteById(userOrderId);
    }

    public UserOrderDto updateOrder(final UserOrderDto userOrderDto) throws EntityNotFoundException {
        if (userOrderRepository.findById(userOrderDto.getId()).isPresent()) {
            return userOrderMapper.toUserOrderDto(userOrderRepository.save(userOrderMapper.toUserOrder(userOrderDto)));
        }
        throw new EntityNotFoundException(UserOrder.class, "id", String.valueOf(userOrderDto.getId()));
    }
}
