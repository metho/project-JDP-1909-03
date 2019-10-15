package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Payment;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(final Payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<Payment> findPaymentById(final long paymentId) {
        return paymentRepository.findById(paymentId);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public void deletePayment(final Long paymentId) throws EntityNotFoundException {
        if (paymentRepository.findById(paymentId).isPresent()) {
            paymentRepository.deleteById(paymentId);
        } else {
            throw new EntityNotFoundException(Payment.class, "id", paymentId.toString());
        }
    }
}
