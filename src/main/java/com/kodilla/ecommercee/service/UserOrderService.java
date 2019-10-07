package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.UserOrderNotFoundException;
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
        return userOrderMapper.mapToUserOrderDtoList(userOrderRepository.findAll());
    }

    public UserOrderDto getOrder(final Long userOrderId) throws UserOrderNotFoundException {
        return userOrderMapper.mapToUserOrderDto(userOrderRepository.findById(userOrderId)
                .orElseThrow(UserOrderNotFoundException::new)
        );
    }

    public UserOrderDto createOrder(final UserOrderDto userOrderDto) {
        return userOrderMapper.mapToUserOrderDto(userOrderRepository.save(userOrderMapper.mapToUserOrder(userOrderDto)));
    }

    public void deleteOrder(Long userOrderId) {
        userOrderRepository.deleteById(userOrderId);
    }

    public UserOrderDto updateOrder(final UserOrderDto userOrderDto) throws UserOrderNotFoundException {
        UserOrder userOrder = userOrderRepository
                .findById(userOrderDto.getId()).orElseThrow(UserOrderNotFoundException::new);
        return userOrderMapper.mapToUserOrderDto(userOrderRepository.save(userOrder));
    }
}
