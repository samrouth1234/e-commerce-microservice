package com.co.customerservice.service;

import com.co.customerservice.dto.CreateCustomerDTO;
import com.co.customerservice.entity.Customer;
import com.co.customerservice.repository.CustomerRepository;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // create customer
    public Customer createCustomer(CreateCustomerDTO createCustomer){
        Customer customer = new Customer();
        customer.setCustomerName(createCustomer.customerName());
        customer.setCity(createCustomer.city());
        customer.setCountry(createCustomer.country());
        customer.setAddress(createCustomer.address());
        customer.setContactName(createCustomer.contactName());
        customer.setPostalCode(createCustomer.postalCode());
        return customerRepository.save(customer);
    }

    // find all customer
    public List<Customer> findAllCustomers() {
     return customerRepository.findAll();
    }

    // find customer by id

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer id " + id + " not found")
        );
    }
}
