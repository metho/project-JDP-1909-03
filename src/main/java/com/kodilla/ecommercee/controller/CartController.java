package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CartController.BASE_API)
@Slf4j
public class CartController {

    static final String BASE_API = "v1/cart";

    @PostMapping("new")
    public void createEmptyCart() {
        log.info("Create new cart");
    }

    @GetMapping("products")
    public List<ProductDto> getCartProducts() {
        log.info("Getting list of products in cart");
        return new ArrayList<>();
    }

    @PutMapping("product")
    public CartDto addProductToCart(ProductDto productDto) {
        log.info("Add product to cart");
        return new CartDto();
    }

    @DeleteMapping("product")
    public CartDto deleteProductFromCart(Long productId) {
        log.info("Delete product from cart");
        return new CartDto();
    }

    @PostMapping("order")
    public UserOrderDto createOrderForCart(Long cartId) {
        log.info("Create order for cart");
        return new UserOrderDto();
    }
}
