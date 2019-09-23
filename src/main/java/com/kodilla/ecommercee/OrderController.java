package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<OrderDto> getAllOrders() {
        System.out.println("List of orders");
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}")
    public OrderDto getOrder(@RequestParam Long orderId) {
        System.out.println("List of orders by id");
        return new OrderDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "", consumes = APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody OrderDto orderDto) {
        System.out.println("Create new order.");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public OrderDto updateOrders(@RequestBody OrderDto orderDto) {
        System.out.println("Update the order");
        return new OrderDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{orderId}")
    public void deleteOrder(@RequestParam Long orderId) {
        System.out.println("Delete order by id");
    }
}
