package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Payment;
import com.kodilla.ecommercee.dto.PaymentDto;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment mapToPayment(final PaymentDto paymentDto) {
        return new Payment(
                paymentDto.getId(),
                paymentDto.getPrice(),
                paymentDto.isPaymentStatus()
        );
    }

    public PaymentDto mapToPaymentDto(final Payment payment) {
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
}
