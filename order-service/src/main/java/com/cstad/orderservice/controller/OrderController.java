package com.cstad.orderservice.controller;

import com.cstad.orderservice.entity.Orders;
import com.cstad.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

//    @PostMapping("/create")
//    public TransactionResponse saveOrder( @RequestBody TransactionRequest request) {
//        return orderService.saveOrder(request);
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Iterable<Orders> findAllOrders() {
        return orderService.findAllOrders();
    }

}
