package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.DatabaseException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.dao.UserDao;
import com.hsbc.model.util.UserFactory;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao = null;
	
	public UserServiceImpl() {
		userDao = (UserDao)UserFactory.getInstance("dao");
	}

	@Override
	public User login(int userId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = userDao.authenticate(userId, password);
		if(user == null) {
			throw new AuthenticationException("Sorry something went wrong");
		}
		return user;
	}

	@Override
	public User createUser(User user) throws DatabaseException{
		// TODO Auto-generated method stub
		User userStored = userDao.store(user);
		if(userStored == null) {
			throw new DatabaseException("Sorry something went wrong");
		}
		return userStored;
	}

	@Override
	public User updatePhone(int userId, long phone) throws UserNotFoundException{
		// TODO Auto-generated method stub
		User user = getUser(userId);
		
		user = userDao.updateUser(userId, user);
		
		
		return user;
	}

	@Override
	public User updatePassword(int userId, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		User user = getUser(userId);
		
		user = userDao.updateUser(userId, user);
		
		
		return user;
	}

	@Override
	public User getUser(int userId) throws UserNotFoundException{
		// TODO Auto-generated method stub
		List<User> list = userDao.fetchAllUsers();
		
		for(User tempList : list) {
			if(tempList.getUserId() == userId) {
				return tempList;
				
			}
		}
		throw new UserNotFoundException("Sorry! User Not Found");
	}

	@Override
	public List<User> fetchAllUsers() throws Exception{
		// TODO Auto-generated method stub
		List<User> list = userDao.fetchAllUsers();
		if(list == null) {
			throw new Exception("something went wrong");
			
		}
		return list;
	}

}
