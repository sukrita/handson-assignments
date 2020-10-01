package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.ContactNotFoundException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.Type;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = null;
	
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance(Type.DAO);
	}

	@Override
	public User login(long profileId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		User user = userDao.authenticate(profileId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went wrong");
		}
		return user;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User userStored = userDao.store(user);
		return userStored;
	}

	@Override
	public User updatePhone(long userId, long phone) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User user = getUser(userId);
		
		if(user == null)
			throw new UserNotFoundException("Sorry User not found");
		
		user.setPhoneNumber(phone);
		user = userDao.updateUser(userId, user);
		
		
		return user;
	}

	@Override
	public User updatePassword(long userId, String password) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User user = getUser(userId);
		
		if(user == null)
			throw new UserNotFoundException("Sorry User not found");
		
		user.setPassword(password);
		user = userDao.updateUser(userId, user);
		
		
		return user;
	}

	@Override
	public User getUser(long userId){
		// TODO Auto-generated method stub
		List<User> list = userDao.fetchAllUsers();
		
		for(User tempList : list) {
			if(tempList.getProfileId() == userId) {
				return tempList;
				
			}
		}
		return null;
	}
	
	public Contacts getContact(long contactId) {
		List<Contacts> list = userDao.fetchAllContacts();
		
		for(Contacts tempList : list) {
			if(tempList.getContactId() == contactId) {
				return tempList;
				
			}
		}
		return null;
		
		
	}

	@Override
	public void deleteUser(long profileId) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Boolean status =userDao.deleteUser(profileId);
		if(status == false)
			throw new UserNotFoundException("Sorry user not found");


	}

	@Override
	public Contacts addContact(long profileId, Contacts contact) {
		// TODO Auto-generated method stub
		Contacts contactStored = userDao.addContact(profileId, contact);
		return contactStored;
	}

	@Override
	public List<Contacts> fetchAllContacts() throws ContactNotFoundException{
		// TODO Auto-generated method stub
		List<Contacts> list = userDao.fetchAllContacts();
		if(list == null)
			throw new ContactNotFoundException("Sorry! Something went wrong");
		return list;
	}

	@Override
	public Contacts updateContactPhone(long profileId, long contactId, long phone) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		Contacts contact = getContact(contactId);
		
		if(contact == null)
			throw new ContactNotFoundException("Sorry Contact not found");
		
		contact.setPhoneNumber(phone);
		contact = userDao.updateContact(profileId, contact);
				
		return contact;

	}

	@Override
	public Contacts updateContactName(long profileId, long contactId, String name) throws ContactNotFoundException {
		// TODO Auto-generated method stub
		Contacts contact = getContact(contactId);
		
		if(contact == null)
			throw new ContactNotFoundException("Sorry Contact not found");
		
		contact.setName(name);
		contact = userDao.updateContact(profileId, contact);
				
		return contact;
	}

}
