package com.anurag.jdbc.controller;

import com.anurag.jdbc.repo.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerDAO customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping("/customer/{id}")
    public String getCustomerName(@PathVariable int id) {
        return customerDAO.getCustomerName(id);
    }
}
