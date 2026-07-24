package com.banking.banking_system.exception;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String message)  {
		super(message);
	}

}
