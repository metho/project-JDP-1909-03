package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/v1/orders")
@Slf4j
public class OrderController {

    @GetMapping(value = "/all")
    public List<UserOrderDto> getAllOrders() {
        log.info("List of orders");
        return new ArrayList<>();
    }

    @GetMapping("{orderId}")
    public UserOrderDto getOrder(@PathVariable Long orderId) {
        log.info("List of orders by id");
        return new UserOrderDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody UserOrderDto UserOrderDto) {
        log.info("Create new order");
    }

    @PutMapping
    public UserOrderDto updateOrders(@RequestBody UserOrderDto UserOrderDto) {
        log.info("Update the order");
        return new UserOrderDto();
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        log.info("Delete order by id");
    }
}
