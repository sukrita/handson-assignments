package com.hsbc.model.beans;

public class Account {
	private int accountNumber;
	private String customerName;
	private double balance;
	private long contactNumber;
	
	private static int accountCounter = 1;
	
	
	// generate account number at the time of object creation
	public Account() {
		super();
		this.accountNumber = accountCounter++;

	}
	
	
	// generate required constructors, getters & setters
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	
	
}
