package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    private User johnS;

    private Cart cart1;
    private Cart cart2;
    private Cart cart3;

    private Product product1;
    private Product product2;
    private Product product3;

    @Before
    public void prepare(){
        johnS = new User("John", "Smith");
        product1 = new Product("Product1", "Toothbrush", new BigDecimal(1.19), true);
        product2 = new Product("Product2", "Soap", new BigDecimal(0.89), true);
        product3 = new Product("Product3", "Loofa", new BigDecimal(3.99), true);
        cart1 = new Cart();
        cart2 = new Cart();
        cart3 = new Cart();

        johnS.setCart(cart3);
        cart3.setUser(johnS);

        userRepository.save(johnS);

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cart2.getProducts().add(product2);
        cart3.getProducts().add(product1);
        cart3.getProducts().add(product2);
        cart3.getProducts().add(product3);

        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
    }

    @Test
    @Transactional
    public void testOneToOne(){
        //Given
        //When
        Optional<User> user = Optional.ofNullable(cartRepository.getOne(cart3.getId()).getUser());
        //Then
        assertTrue(user.isPresent());
        assertThat(user.equals(Optional.of(johnS)));
    }

    @Test
    public void testSavingCarts(){
        //Given
        //When
    long cart1Id = cart1.getId();
    long cart2Id = cart2.getId();
    long cart3Id = cart3.getId();

        //Then
        assertNotEquals(0, cart1Id);
        assertNotEquals(0, cart2Id);
        assertNotEquals(0, cart3Id);
    }

    @Test
    public void testRetrievingProductsFromCarts(){
        //Given
        //When
        List<Product> cart1products = cart1.getProducts();
        List<Product> cart2products = cart2.getProducts();
        List<Product> cart3products = cart3.getProducts();
        //Then
        assertEquals(2, cart1products.size());
        assertEquals(1, cart2products.size());
        assertEquals(3, cart3products.size());

    }

    @After
    public void cleanUp(){

        cartRepository.deleteById(cart1.getId());
        userRepository.deleteById(johnS.getId());
    }
}
