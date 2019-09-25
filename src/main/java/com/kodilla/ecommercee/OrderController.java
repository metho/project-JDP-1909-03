package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserOrderDto;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/v1/orders")
public class OrderController {

    @GetMapping(value = "/all")
    public List<UserOrderDto> getAllOrders() {
        System.out.println("List of orders");
        return new ArrayList<>();
    }

    @GetMapping("{orderId}")
    public UserOrderDto getOrder(@PathVariable Long orderId) {
        System.out.println("List of orders by id");
        return new UserOrderDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody UserOrderDto UserOrderDto) {
        System.out.println("Create new order");
    }

    @PutMapping
    public UserOrderDto updateOrders(@RequestBody UserOrderDto UserOrderDto) {
        System.out.println("Update the order");
        return new UserOrderDto();
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        System.out.println("Delete order by id");
    }
}