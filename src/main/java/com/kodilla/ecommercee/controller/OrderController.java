package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/orders")
@Slf4j
public class OrderController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody UserOrderDto userOrderDto) {
        log.info("Create new order {} for user {}", userOrderDto.getNumber(), userOrderDto.getUserId());
    }

    @GetMapping("{orderId}")
    public UserOrderDto getOrder(@PathVariable Long orderId) {
        log.info("Get order by ID = {}", orderId);
        return new UserOrderDto();
    }

    @GetMapping(value = "/all")
    public List<UserOrderDto> getAllOrders() {
        log.info("Get list of orders");
        return new ArrayList<>();
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        log.info("Delete order by ID = {}", orderId);
    }

    @PutMapping
    public UserOrderDto updateOrders(@RequestBody UserOrderDto userOrderDto) {
        log.info("Update the order with ID = {}", userOrderDto.getId());
        return new UserOrderDto();
    }
}
