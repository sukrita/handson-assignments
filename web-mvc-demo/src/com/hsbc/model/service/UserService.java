package com.hsbc.model.service;

import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.exception.DatabaseException;
import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;

public interface UserService {
	
	public User login(int userId, String password) throws AuthenticationException;
	public User createUser(User user) throws DatabaseException;
	public User updatePhone(int userId, long phone) throws UserNotFoundException;
	public User updatePassword(int userId, String password) throws UserNotFoundException;
	public User getUser(int userId) throws UserNotFoundException;
	public List<User> fetchAllUsers() throws Exception;

}
