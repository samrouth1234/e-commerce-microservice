package com.cstad.paymentservice.service;

import com.cstad.paymentservice.entity.Payment;
import com.cstad.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payment);
    }

    public String paymentProcessing() {
        // api should be 3rd party payment gateway (paypal, paytm, payu etc)
        return new Random().nextBoolean()?"success":"false";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

}
