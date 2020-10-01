package com.hsbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.beans.Contacts;
import com.hsbc.model.beans.User;
import com.hsbc.model.util.DBUtility;

public class JdbcBackedUserDaoImpl implements UserDao{

	@Override
	public User authenticate(long profileId, String password) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Connection connection = DBUtility.getConnection();
			String loginQuery = "select * from profile_table where profile_id = ? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
			preparedStatement.setLong(1, profileId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new User(resultSet.getLong("profile_id"));
				//user.setProfileId(resultSet.getLong("profile_id"));
				user.setUserName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhoneNumber(resultSet.getLong("phone"));
				user.setDateOfBirth(resultSet.getString("dob"));
				return user;
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			System.out.println(user);
			if(user == null) {
				throw new AuthenticationException("Sorry Profile Id or Password is Incorrect");
			} 
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User store(User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String registerQuery = "insert into profile_table values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
			preparedStatement.setLong(1, user.getProfileId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getPhoneNumber());
			preparedStatement.setString(5, user.getDateOfBirth());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<User> fetchAllUsers() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from profile_table");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User();
				user.setProfileId(resultSet.getLong("profile_id"));
				user.setUserName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				user.setPhoneNumber (resultSet.getLong("phone"));
				list.add(user);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User updateUser(long profileId, User user) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String updateQuery = "update profile_table set password = ?, phone = ? where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setLong(2, user.getPhoneNumber());
			preparedStatement.setLong(3, profileId);
			int count = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Boolean deleteUser(long profileId) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String deleteQuery = "delete from profile_table where profile_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setLong(1, profileId);
			int count = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			return true;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Contacts addContact(long profileId, Contacts contact) {
		// TODO Auto-generated method stub
		Contacts returnContact = null;
		try {
			Connection connection = DBUtility.getConnection();
			String registerQuery = "insert into contacts_table values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
			preparedStatement.setLong(1, profileId);
			preparedStatement.setLong(2, contact.getContactId());
			preparedStatement.setString(3, contact.getName());
			preparedStatement.setLong(4, contact.getPhoneNumber());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contact;
	}

	@Override
	public List<Contacts> fetchAllContacts() {
		// TODO Auto-generated method stub
		List<Contacts> list = new ArrayList<Contacts>();
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from contacts_table");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Contacts contact = new Contacts();
				contact.setContactId(resultSet.getLong("contact_id"));
				contact.setName(resultSet.getString("name"));
				contact.setPhoneNumber(resultSet.getLong("phone"));
				list.add(contact);
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Contacts updateContact(long profileId, Contacts contact) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DBUtility.getConnection();
			String updateQuery = "update contact_table set name = ?, phone = ? where profile_id = ? and contact_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, contact.getName());
			preparedStatement.setLong(2, contact.getPhoneNumber());
			preparedStatement.setLong(3, profileId);
			preparedStatement.setLong(4, contact.getProfileId());
			int count = preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contact;
	}

}
