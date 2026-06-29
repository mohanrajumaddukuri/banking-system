package com.banking.banking_system.service;

import org.springframework.stereotype.Service;

import com.banking.banking_system.entity.Customer;

@Service
public class CustomerService {

	public Customer getCustomers() {
		return new Customer(101, "Mohan", "Maddukuri", "mohan@gmail.com");
	}
}
