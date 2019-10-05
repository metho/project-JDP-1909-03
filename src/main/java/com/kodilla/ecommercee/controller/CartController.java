package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/cart")
@Slf4j
public class CartController {

    static final String BASE_API = "v1/cart";

    @Autowired
    private CartService cartService;

    @PostMapping()
    public CartDto createEmptyCart() {
        log.info("Create new cart");
        return cartService.createEmptyCart();
    }

    @GetMapping("products")
    public List<ProductDto> getCartProducts(@RequestParam Long cartId) throws CartNotFoundException {
        log.info("Get list of products in cart");
        return cartService.getCartProducts(cartId);
    }

    @PutMapping("product")
    public CartDto addProductToCart(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotFoundException, ProductNotFoundException {
        log.info("Add product with id = {} to cart with id = {}", productId, cartId);
        return cartService.addProductToCart(cartId, productId);
    }

    @DeleteMapping("product")
    public CartDto deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotFoundException, ProductNotFoundException {
        log.info("Delete product by ID = {} from cart", productId);
        return cartService.deleteProductFromCart(cartId, productId);
    }

    @PostMapping("order")
    public UserOrderDto createOrderForCart(@RequestParam Long cartId) throws CartNotFoundException {
        log.info("Create order for cart {}", cartId);
        return cartService.createOrderForCart(cartId);
    }
}
