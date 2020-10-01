package com.hsbc.model.dao;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.User;

public class FileBackedUserDao implements UserDao{

	private List<User> userList = deserialize();
	
	public void serialize(List<User> userList) {
		
		try {
			FileOutputStream fos = new FileOutputStream("fileDb.ser");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(userList);
			
			fos.flush(); // flushes the output stream
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private List<User> deserialize() {
		
		try {
			FileInputStream fis = new FileInputStream("fileDb.ser");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			userList = (List<User>) ois.readObject();

			ois.close();
			fis.close();
			


			
		} catch (FileNotFoundException | EOFException e) {
			// TODO Auto-generated catch block
			userList = new ArrayList<User>();
			serialize(userList);
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		
		
	}

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		this.userList = deserialize();
		int generatedId = userList.size()+1;
		user.setUserId(generatedId);
		this.userList.add(user);
		serialize(this.userList);
		
		return user;
	}

	@Override
	public User[] fetchUsers() {
		// TODO Auto-generated method stub
		
		userList = deserialize();
		
		User[] userArray = new User[userList.size()];
		
		userArray = userList.toArray(userArray);

		
		return userArray;
	}

	@Override
	public User fetchUserById(int userId) {
		// TODO Auto-generated method stub
		
		userList = deserialize();
		
		return userList.get(userId);
	}

	@Override
	public User updateUser(int userId, User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	


