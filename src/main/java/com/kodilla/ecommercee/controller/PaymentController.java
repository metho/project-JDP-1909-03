package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.PaymentDto;
import com.kodilla.ecommercee.exception.PaymentNotFoundException;
import com.kodilla.ecommercee.exception.UserOrderNotFoundException;
import com.kodilla.ecommercee.mapper.PaymentMapper;
import com.kodilla.ecommercee.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private PaymentService paymentService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createPayment(@RequestBody PaymentDto paymentDto) throws UserOrderNotFoundException {
        log.info("Create a payment for order ID {}", paymentDto.getUserOrderId());
        paymentService.savePayment(paymentMapper.toPayment(paymentDto));
    }

    @GetMapping("{paymentId}")
    public PaymentDto getPayment(@PathVariable Long paymentId) throws PaymentNotFoundException {
        log.info("Get payment by ID = {}", paymentId);
        return paymentMapper.toPaymentDto(paymentService.findPaymentById(paymentId).orElseThrow(PaymentNotFoundException::new));
    }

    @GetMapping(value = "all")
    public List<PaymentDto> getPayments() {
        log.info("Get list of payments");
        return paymentMapper.toPaymentDtoList(paymentService.findAllPayments());
    }

    @PutMapping
    public PaymentDto updatePayment(@RequestBody PaymentDto paymentDto) throws UserOrderNotFoundException {
        log.info("Update the payment for order ID = {}", paymentDto.getUserOrderId());
        return paymentMapper.toPaymentDto(paymentService.savePayment(paymentMapper.toPayment(paymentDto)));
    }

    @DeleteMapping("{paymentId}")
    public void deletePayment(@PathVariable Long paymentId) throws PaymentNotFoundException {
        log.info("Delete payment by ID = {}", paymentId);
        paymentService.deletePayment(paymentId);
    }
}
