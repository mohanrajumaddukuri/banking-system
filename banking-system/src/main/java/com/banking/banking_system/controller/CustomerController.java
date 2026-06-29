package com.banking.banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.service.CustomerService;

@RestController
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
		
	}
	
	@GetMapping("/api/v1/customers")
	public Customer getCustomers() {
		return customerService.getCustomers();
	}
	
}
