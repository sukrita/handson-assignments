package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;

public interface UserService {
	
	public User login(long profileId, String password) throws AuthenticationException;
	public User createUser(User user);
	public User updatePhone(long userId, long phone) throws UserNotFoundException;
	public User updatePassword(long userId, String password) throws UserNotFoundException;
	public User getUser(long userId);
	public void deleteUser(long profileId) throws UserNotFoundException;
	public Contacts addContact(long profileId, Contacts contact);
	public List<Contacts> fetchAllContacts() throws ContactNotFoundException;
	public Contacts updateContactPhone(long profileId, long contactId, long phone) throws ContactNotFoundException;
	public Contacts updateContactName(long profileId, long contactId, String name) throws ContactNotFoundException;
}
