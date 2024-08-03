package com.cstad.paymentservice.controller;

import com.cstad.paymentservice.entity.Payment;
import com.cstad.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Payment doPayment(@RequestBody Payment payment) {
        return paymentService.doPayment(payment);
    }

    @GetMapping("/{orderId}")
    public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) {
        return paymentService.findPaymentHistoryByOrderId(orderId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Iterable<Payment> findAllPayments() {
        return paymentService.findAllPayments();
    }

}
