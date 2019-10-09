package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.UserOrderNotFoundException;
import com.kodilla.ecommercee.mapper.UserOrderMapper;
import com.kodilla.ecommercee.service.UserOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/orders")
@Slf4j
public class OrderController {

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    UserOrderMapper userOrderMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserOrderDto createOrder(@RequestBody UserOrderDto userOrderDto) {
        log.info("Create new order {} for user {}", userOrderDto.getNumber(), userOrderDto.getUserDto());
        return userOrderService.createOrder(userOrderDto);
    }

    @GetMapping("{orderId}")
    public UserOrderDto getOrder(@PathVariable Long orderId) throws UserOrderNotFoundException {
        log.info("Get order by ID = {}", orderId);
        return userOrderService.getOrder(orderId);
    }

    @GetMapping("all")
    public List<UserOrderDto> getAllOrders() {
        log.info("Get list of orders");
        return userOrderService.getAllOrder();
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        log.info("Delete order by ID = {}", orderId);
        userOrderService.deleteOrder(orderId);
    }

    @PutMapping
    public UserOrderDto updateOrders(@RequestBody UserOrderDto userOrderDto) throws UserOrderNotFoundException {
        log.info("Update the order with ID = {}", userOrderDto.getId());
        return userOrderService.updateOrder(userOrderDto);
    }
}
