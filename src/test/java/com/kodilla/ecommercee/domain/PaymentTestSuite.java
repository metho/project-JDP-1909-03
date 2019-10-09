package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.PaymentRepository;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentTestSuite {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    private static final String NUMBER = "101";
    private static final String NUMBER1 = "102";
    private User user = new User("Jan", "Kowalski");
    private User user1 = new User("Anna", "Kowalska");

    @Test
    public void testPayment() {
        //Given
        userRepository.save(user);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        Payment payment = new Payment();
        payment.setUserOrder(userOrder);
        payment.setPrice(new BigDecimal("100"));
        payment.setStatusPayment(false);
        paymentRepository.save(payment);

        //When
        List<Payment> foundPayments = paymentRepository.findAll();

        //Then
        Assert.assertEquals(1, foundPayments.size());

        //CleanUp
        paymentRepository.deleteById(payment.getId());
        userOrderRepository.deleteById(userOrder.getId());
        userRepository.deleteById(user.getId());
    }

    @Test
    public void testPayments() {
        //Given
        userRepository.save(user);
        userRepository.save(user1);

        UserOrder userOrder = new UserOrder();
        userOrder.setNumber(NUMBER);
        userOrder.setUser(user);
        userOrder.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder);

        UserOrder userOrder1 = new UserOrder();
        userOrder1.setNumber(NUMBER1);
        userOrder1.setUser(user1);
        userOrder1.setOrderDate(LocalDate.now());
        userOrderRepository.save(userOrder1);

        Payment payment = new Payment();
        payment.setUserOrder(userOrder);
        payment.setPrice(new BigDecimal("100"));
        payment.setStatusPayment(false);
        paymentRepository.save(payment);

        Payment payment1 = new Payment();
        payment1.setUserOrder(userOrder1);
        payment1.setPrice(new BigDecimal("100"));
        payment1.setStatusPayment(true);
        paymentRepository.save(payment1);

        //When
        List<Payment> foundPayments = paymentRepository.findAll();

        //Then
        Assert.assertEquals(2, foundPayments.size());

        //CleanUp
        paymentRepository.deleteById(payment.getId());
        userOrderRepository.deleteById(userOrder.getId());
        userRepository.deleteById(user.getId());

        paymentRepository.deleteById(payment1.getId());
        userOrderRepository.deleteById(userOrder1.getId());
        userRepository.deleteById(user1.getId());


    }
}
