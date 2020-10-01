package com.hsbc.model.beans;

import java.util.Date;

public class User {
	
	private String userName, password;
	private long phoneNumber;
	private String dateOfBirth;
	
	private static long profileId = 0;
	public User() {
		super();
		this.profileId += 1 ;
	}
	
	public User(long profileId) {
		super();
		this.profileId = profileId ;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public static long getProfileId() {
		return profileId;
	}
	public static void setProfileId(long profileId) {
		User.profileId = profileId;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	
	
	

}
