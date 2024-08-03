package com.cstad.orderservice.service;

import com.cstad.orderservice.entity.Orders;
import com.cstad.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {
    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;

//    public TransactionResponse saveOrder(TransactionRequest request) {
//        String response = "";
//        Orders order = request.getOrder();
//        Payment payment = request.getPayment();
//        payment.setOrderId(orders.getId());
//        payment.setAmount(order.getPrice());
//
//        // rest call
//        Payment paymentResponse = restTemplate.postForObject("http://PAYMENT-SERVICE/api/v1/payment", payment, Payment.class);
//        response = paymentResponse.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is a failure in payment api, order added to cart";
//        orderRepository.save(order);
//
//        return new TransactionResponse( order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
//    }

    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }


}
