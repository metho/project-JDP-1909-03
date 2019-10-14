package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.UserOrderDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.exception.NumberAlreadyInDatabaseException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.mapper.UserOrderMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private UserRepository userRepository;

    public CartDto createEmptyCart(final Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException(User.class, "id", userId.toString()));
        Cart cart = new Cart();
        cart.setUser(user);
        user.setCart(cart);
        cartRepository.save(cart);
        return cartMapper.toCartDto(cart);
    }

    public List<ProductDto> getCartProducts(final Long cartId) throws EntityNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException(Cart.class, "id", cartId.toString()));
        return productMapper.toProductDtoList(cart.getProducts());
    }

    public CartDto addProductToCart(final Long cartId, final Long productId) throws EntityNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException(Cart.class, "id", cartId.toString()));
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", productId.toString()));
        cart.addProduct(product);
        return cartMapper.toCartDto(cartRepository.save(cart));
    }

    public CartDto deleteProductFromCart(final Long cartId, final Long productId) throws EntityNotFoundException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException(Cart.class, "id", cartId.toString()));
        Product product = productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", productId.toString()));
        cart.deleteProduct(product);
        return cartMapper.toCartDto(cartRepository.save(cart));
    }

    public UserOrderDto createOrderForCart(final Long cartId, final String number) throws EntityNotFoundException, NumberAlreadyInDatabaseException {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new EntityNotFoundException(Cart.class, "id", cartId.toString()));
        if (userOrderRepository.findAll().stream().anyMatch(userOrder -> userOrder.getNumber().equals(number))) {
            throw new NumberAlreadyInDatabaseException("There is already an order with number: " + number + " in database.");
        }
        UserOrder userOrder = new UserOrder(number, Optional.ofNullable(cart.getUser()).orElseThrow(() -> new EntityNotFoundException(User.class, "id", cart.getUser().getId().toString())));
        userOrderRepository.save(userOrder);
        return userOrderMapper.toUserOrderDto(userOrder);
    }
}
