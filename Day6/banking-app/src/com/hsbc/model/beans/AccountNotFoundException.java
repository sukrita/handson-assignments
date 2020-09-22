package com.hsbc.model.beans;

// Add constructors inside AccountNotFoundException
public class AccountNotFoundException extends Exception {

	public AccountNotFoundException() {
		super("Account not found");
		// TODO Auto-generated constructor stub
	}

	public AccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
