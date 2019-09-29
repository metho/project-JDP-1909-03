package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CartController.BASE_API)
public class CartController {

    static final String BASE_API = "v1/cart";
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @PostMapping("new")
    public void createEmptyCart() {
        LOGGER.info("Creating an empty cart.");
        //implementation
    }

    @GetMapping("products")
    public List<ProductDto> getCartProducts() {
        LOGGER.info("Getting cart products.");

        return new ArrayList<>();
    }

    @PutMapping("product")
    public CartDto addProductToCart(ProductDto productDto) {
        LOGGER.info("Adding product to cart");

        return new CartDto();
    }

    @DeleteMapping("product")
    public CartDto deleteProductFromCart(Long productId) {
        LOGGER.info("Deleting product with id: " + productId + " from cart");

        return new CartDto();
    }

    @PostMapping("order")
    public UserOrderDto createOrderForCart(Long cartId) {
        LOGGER.info("Creating order for cart nr: " + cartId);
        return new UserOrderDto();
    }
}
