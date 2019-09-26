package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.AddressRepository;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CartRepository cartRepository;

    private static final String NAME = "John";
    private static final String SURNAME = "Smith";
    private static final String STREET = "1234 Lincoln";
    private static final String CODE = "NY10003";
    private static final String CITY = "New York";

    @Test
    public void testUserSave() {
        //Given
        User user = new User(NAME, SURNAME);

        //When
        userRepository.save(user);

        //Then
        long userId = user.getId();
        Optional<User> savedUser = userRepository.findById(userId);
        Assert.assertTrue(savedUser.isPresent());

        //CleanUp
        userRepository.deleteById(userId);
    }

    @Test
    public void testUserFindBySurname() {
        //Given
        User user = new User(NAME, SURNAME);
        userRepository.save(user);
        String userSurname = user.getSurname();

        //When
        List<User> foundUsers = userRepository.findBySurname(userSurname);

        //Then
        Assert.assertEquals(1, foundUsers.size());

        //CleanUp
        long foundUserId = foundUsers.get(0).getId();
        userRepository.deleteById(foundUserId);
    }

    @Test
    public void testUserSaveWithAddress() {
        //Given
        User user = new User(NAME, SURNAME);
        Address address = new Address(STREET, CODE, CITY);
        user.setAddress(address);

        //When
        userRepository.save(user);

        //Then
        long savesAddressId = address.getId();
        Optional<Address> savedAddress = addressRepository.findById(savesAddressId);
        Assert.assertTrue(savedAddress.isPresent());

        //CleanUp
        userRepository.deleteById(user.getId());
    }

    @Test
    public void testUserSaveWithCart() {
        //Given
        User user = new User(NAME, SURNAME);
        Cart cart = new Cart();
        user.setCart(cart);

        //When
        userRepository.save(user);

        //Then
        long savedCartId = cart.getId();
        Optional<Cart> savedCart = cartRepository.findById(savedCartId);
        Assert.assertTrue(savedCart.isPresent());

        //CleanUp
        userRepository.deleteById(user.getId());
    }
}
