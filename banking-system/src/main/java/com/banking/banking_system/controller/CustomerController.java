package com.banking.banking_system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
		
	}
	
	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
}
