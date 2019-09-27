package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CartController.BASE_API)
public class CartController {

    static final String BASE_API = "v1/cart";

    @PostMapping("new")
    public void createEmptyCart() {
        //implementation
    }

    @GetMapping("products")
    public List<ProductDto> getCartProducts() {
        return new ArrayList<>();
    }

    @PutMapping("product")
    public CartDto addProductToCart(ProductDto productDto) {
        return new CartDto();
    }

    @DeleteMapping("product")
    public CartDto deleteProductFromCart(Long productId) {
        return new CartDto();
    }

    @PostMapping("order")
    public UserOrderDto createOrderForCart(Long cartId) {
        return new UserOrderDto();
    }
}
