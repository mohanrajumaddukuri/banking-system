package com.banking.banking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this .customerRepository=customerRepository;
	}
	

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
}
