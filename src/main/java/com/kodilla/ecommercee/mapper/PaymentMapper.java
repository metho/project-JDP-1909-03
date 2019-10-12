package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Payment;
import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.dto.PaymentDto;
import com.kodilla.ecommercee.exception.UserOrderNotFoundException;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PaymentMapper {
    @Autowired
    private UserOrderRepository userOrderRepository;

    public Payment toPayment(final PaymentDto paymentDto) throws UserOrderNotFoundException {
        Payment payment = new Payment(
                paymentDto.getId(),
                paymentDto.getPrice(),
                paymentDto.isPaymentStatus()
        );
        try {
            payment.setUserOrder(userOrderRepository.findById(paymentDto.getUserOrderId()).get());
        } catch (NoSuchElementException e) {
            throw new UserOrderNotFoundException();
        }
        return payment;
    }

    public PaymentDto toPaymentDto(final Payment payment) {
        PaymentDto paymentDto = new PaymentDto(
                payment.getId(),
                payment.getPrice(),
                payment.isPaymentStatus()
        );
        if(payment.getUserOrder() != null) {
            paymentDto.setUserOrderId(payment.getUserOrder().getId());
        }
        return paymentDto;
    }

    public List<PaymentDto> toPaymentDtoList(final List<Payment> payments) {
        return payments.stream()
                .map(this::toPaymentDto)
                .collect(Collectors.toList());
    }
}
