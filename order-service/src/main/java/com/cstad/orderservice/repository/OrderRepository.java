package com.cstad.orderservice.repository;

import com.cstad.orderservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Orders, Integer> {

}
