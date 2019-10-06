package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.UserOrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOrderTestSuite {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String NUMBER = "101";

    User user = new User(null, "Jan", "Kowalski");

    @Test
    public void testFindAllOrders() {
        //Given
        userRepository.save(user);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        //When
        List<UserOrder> foundAllOrders = userOrderRepository.findAll();

        //Then
        Assert.assertEquals(1, foundAllOrders.size());

        //CleanUp
        long userOrderId = foundAllOrders.get(0).getId();
        userOrderRepository.deleteById(userOrderId);
        userRepository.delete(user);
    }

    @Test
    public void testGetUserOrderById() {
        //Given
        userRepository.save(user);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        //When
        Optional<UserOrder> foundUserOrderById = userOrderRepository.findById(userOrder.getId());

        //Then
        Assert.assertNotNull(foundUserOrderById);

        //CleanUp
        long userOrderId = foundUserOrderById.get().getId();
        userOrderRepository.deleteById(userOrderId);
        userRepository.delete(user);
    }

    @Test
    public void testDeleteUserOrderById() {
        //Given
        userRepository.save(user);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        //When
        userOrderRepository.deleteById(userOrder.getId());

        //Then
        Assert.assertTrue( userOrderRepository.findAll().size() == 0);

        //CleanUp
        userRepository.delete(user);
    }

    @Test
    public void testUpdateUserOrder() {
        //Given
        userRepository.save(user);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        //When
        userOrder.setNumber("201");
        UserOrder updateUserOrder = userOrderRepository.save(userOrder);

        //Then
        Assert.assertEquals("201", updateUserOrder.getNumber());

        //CleanUp
        long userOrderUpdate = updateUserOrder.getId();
        userOrderRepository.deleteById(userOrderUpdate);
        userRepository.delete(user);
    }
}
