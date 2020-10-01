package com.hsbc.model.dao;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;

public interface UserDao {
	public User authenticate(long profileId, String password) throws AuthenticationException;
	public User store(User user);
	public List<User> fetchAllUsers();
	public User updateUser(long profileId, User user);
	public Boolean deleteUser(long profileId);
	public Contacts addContact(long profileId, Contacts contact);
	public List<Contacts> fetchAllContacts();
	public Contacts updateContact(long profileId, Contacts contact);


}
