package com.hsbc.model.beans;

public class Contacts extends User{
	
	private String name;
	private long phoneNumber;
	
	private static long contactId = 0;
	

	public Contacts() {
		super();
		this.contactId += 1;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public long getContactId() {
		return contactId;
	}
	
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	

}
