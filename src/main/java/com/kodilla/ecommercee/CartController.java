package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(CartController.BASE_API)
public class CartController {

    static final String BASE_API = "v1/cart";

    @RequestMapping(method = RequestMethod.POST, value = "new")
    public void createEmptyCart() {
        //implementation
    }

    @RequestMapping(method = RequestMethod.GET, value = "products")
    public List<ProductDto> getCartProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "products/add")
    public CartDto addProductToCart(ProductDto productDto) {
        return new CartDto();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "products/delete")
    public CartDto deleteProductFromCart(Long productId) {
        return new CartDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = "order/new")
    public OrderDto createOrderBasedOnCart(Long cartId) {
        return new OrderDto();
    }
}