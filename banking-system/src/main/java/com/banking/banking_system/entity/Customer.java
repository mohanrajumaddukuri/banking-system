package com.banking.banking_system.entity;


public class Customer {

	public Integer id;
	
	public String fisrtName;
	
	public String lastName;
	
	public String email;

	public Customer(Integer id, String fisrtName, String lastName, String email) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
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
