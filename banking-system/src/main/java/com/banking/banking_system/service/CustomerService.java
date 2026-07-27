package com.banking.banking_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.banking_system.dto.CustomerRequest;
import com.banking.banking_system.dto.CustomerResponse;
import com.banking.banking_system.entity.Customer;
import com.banking.banking_system.exception.CustomerNotFoundException;
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

	public Customer getCustomerById( Long id) {
		return customerRepository.findById(id).orElseThrow(()-> 
		new CustomerNotFoundException("Customer Not Found "+id));
	}
	
//	public Customer saveCustomer(Customer customer) {
//		return customerRepository.save(customer);
//	}
	
	public CustomerResponse createCustomer(CustomerRequest request) {
		
		Customer customer=new Customer();
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setEmail(request.getEmail());
		
		Customer savedCustomer=customerRepository.save(customer);
		
		CustomerResponse response=new CustomerResponse();
		response.setId(savedCustomer.getId());
		response.setFirstName(savedCustomer.getFirstName());
		response.setLastName(savedCustomer.getLastName());
		response.setEmail(savedCustomer.getEmail());
		
		return response;
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
