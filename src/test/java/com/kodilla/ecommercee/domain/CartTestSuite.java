package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {

    @Autowired
    private CartRepository cartRepository;

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

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product2);
        cart2.getProducts().add(product2);
        cart3.getProducts().add(product1);
        cart3.getProducts().add(product2);
        cart3.getProducts().add(product3);

        product1.getCarts().add(cart1);
        product1.getCarts().add(cart3);
        product2.getCarts().add(cart1);
        product2.getCarts().add(cart2);
        product2.getCarts().add(cart3);
        product3.getCarts().add(cart3);

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
    public void testSavingProducts(){
        //Given
        //When
    long product1Id = product1.getId();
    long product2Id = product2.getId();
    long product3Id = product3.getId();

        //Then
        assertNotEquals(0, product1Id);
        assertNotEquals(0, product2Id);
        assertNotEquals(0, product3Id);
    }

    @After
    public void cleanUp(){

        cartRepository.deleteById(cart1.getId());
    }
}
