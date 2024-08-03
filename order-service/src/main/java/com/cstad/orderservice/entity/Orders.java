package com.cstad.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_TB")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer customerId;

    private Integer employeeId;

    private LocalDate orderDate;

    private Integer shipperId;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
