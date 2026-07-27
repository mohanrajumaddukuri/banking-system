package com.banking.banking_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CustomerRequest {

	@NotBlank(message="First name is required")
	@Size(min=3,max=30,message = "First name must be between 3 and 30 characters")
	private String firstName;

	@NotBlank(message="Last name is required")
	@Size(min=3,max=30,message = "Last name must be between 3 and 30 characters")
    private String lastName;

	@NotBlank(message="Email is required")
	@Email(message="Please enter a valid email")
    private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}
