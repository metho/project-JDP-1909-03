package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.mapper.UserOrderMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserOrderMapper userOrderMapper;

    private int counter = 0;

    public CartDto createEmptyCart() {
        Cart cart = new Cart();
        cartRepository.save(cart);
        return new CartDto();
    }

    public List<ProductDto> getCartProducts(final Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        return productMapper.mapToProductDtoList(cart.getProducts());
    }

    public CartDto addProductToCart(final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        cart.addProduct(product);
        product.addCart(cart);
        return cartMapper.mapToCartDto(cart);
    }

    public CartDto deleteProductFromCart(final Long cartId, final Long productId) throws CartNotFoundException, ProductNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);

        cart.deleteProduct(product);
        product.deleteCart(cart);
        return cartMapper.mapToCartDto(cart);
    }

    public UserOrderDto createOrderForCart(final Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new);
        String number = LocalDate.now().toString() + counter++;
        UserOrder userOrder = new UserOrder(number, cart.getUser());
        userOrderRepository.save(new UserOrder(number, cart.getUser()));
        return userOrderMapper.mapToUserOrderDto(userOrder);
    }
}
