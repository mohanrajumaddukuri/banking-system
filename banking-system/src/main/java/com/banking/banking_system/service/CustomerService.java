package com.banking.banking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.banking_system.dto.CustomerRequest;
import com.banking.banking_system.dto.CustomerResponse;
import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.exception.CustomerNotFoundException;
import com.banking.banking_system.mapper.CustomerMapper;
import com.banking.banking_system.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	public CustomerService(CustomerRepository customerRepository,CustomerMapper customerMapper) {
		this .customerRepository=customerRepository;
		this.customerMapper=customerMapper;
	}
	

	public List<CustomerResponse> getCustomers() {
		
		List<Customer> customers =customerRepository.findAll();
		
		return customers.stream().map(customerMapper::toResponse).toList();
	}

	public CustomerResponse getCustomerById( Long id) {
		Customer customer= customerRepository.findById(id).orElseThrow(()-> 
		new CustomerNotFoundException("Customer Not Found "+id));

		return customerMapper.toResponse(customer);
	}
	
	public CustomerResponse createCustomer(CustomerRequest request) {
		
		Customer customer=customerMapper.toEntity(request);
		
		Customer savedCustomer=customerRepository.save(customer);
		
		return customerMapper.toResponse(savedCustomer);
		
	}
	
	public Customer updateCustomer(Long id, Customer updatedCustomer) {
		
		Customer existingCustomer=customerRepository.findById(id).orElseThrow(()-> 
		new CustomerNotFoundException("Customer Not Found "+id));
		
		existingCustomer.setFirstName(updatedCustomer.getFirstName());
		existingCustomer.setLastName(updatedCustomer.getLastName());
		existingCustomer.setEmail(updatedCustomer.getEmail());
		
		return customerRepository.save(existingCustomer);
	}
	
	public void deleteCustomer(Long id) {
		
		if(!customerRepository.existsById(id)) {
			throw new CustomerNotFoundException("Customer Not Found "+id);
		}
		customerRepository.deleteById(id);
	}
}
