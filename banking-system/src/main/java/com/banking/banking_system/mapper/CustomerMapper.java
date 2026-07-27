package com.banking.banking_system.mapper;

import org.springframework.stereotype.Component;

import com.banking.banking_system.dto.CustomerRequest;
import com.banking.banking_system.dto.CustomerResponse;
import com.banking.banking_system.entity.Customer;

@Component
public class CustomerMapper {

	public Customer toEntity(CustomerRequest request) {
		
		Customer customer=new Customer();
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setEmail(request.getEmail());
		
		return customer;
	}
	
	public CustomerResponse toResponse(Customer customer) {
		
		CustomerResponse response=new CustomerResponse();
		response.setId(customer.getId());
		response.setFirstName(customer.getFirstName());
		response.setLastName(customer.getLastName());
		response.setEmail(customer.getEmail());
		
		return response;
		
	}
}
