package com.hsbc.model.dao;

import java.util.*;

import com.hsbc.model.beans.User;

public class CollectionBackedArrayUserDao implements UserDao{
	
	
	private static List<User> userList = new ArrayList<User>();

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		
		userList.add(user);
		return user;
	}

	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
		User[] userArray = new User[userList.size()];
		
		for(int i = 0; i < userArray.length ;i++) {
			
			userArray[i] = userList.get(i);
			
		}
		
		
		return userArray;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		
		return userList.get(userId);
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		userList.set(userId, user);
		return null;
	}

}
