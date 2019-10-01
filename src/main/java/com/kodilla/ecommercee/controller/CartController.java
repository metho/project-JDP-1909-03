package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/cart")
@Slf4j
public class CartController {

    @PostMapping("new")
    public void createEmptyCart() {
        log.info("Create new cart");
    }

    @GetMapping("products")
    public List<ProductDto> getCartProducts() {
        log.info("Get list of products in cart");
        return new ArrayList<>();
    }

    @PutMapping("product")
    public CartDto addProductToCart(ProductDto productDto) {
        log.info("Add product " + productDto.getName() +" to cart " + productDto.getGroupId());
        return new CartDto();
    }

    @DeleteMapping("product")
    public CartDto deleteProductFromCart(Long productId) {
        log.info("Delete product by ID " + productId + " from cart");
        return new CartDto();
    }

    @PostMapping("order")
    public UserOrderDto createOrderForCart(Long cartId) {
        log.info("Create order for cart " + cartId);
        return new UserOrderDto();
    }
}
