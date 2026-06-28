package com.banking.banking_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@GetMapping("/api/v1/customers")
	public String getCustomers() {
		return "Welcome to Banking Management System";
	}
}
