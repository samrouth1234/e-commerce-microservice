package com.co.customerservice.dto;

public record CreateCustomerDTO(
         Long customerId,
         String customerName,
         String contactName,
         String address,
         String city,
         String postalCode,
         String country) {
}
