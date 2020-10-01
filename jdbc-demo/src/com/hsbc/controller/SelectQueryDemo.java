package com.hsbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.derby.jdbc.ClientDriver;

import com.hsbc.model.beans.User;
import com.hsbc.model.utility.DBUtility;

public class SelectQueryDemo {

	public static void main(String[] args) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where user_id = ?");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter userid to fetch");
			int userId = scanner.nextInt();
			preparedStatement.setInt(1, userId);
			// 4th step is to execute the query
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User user = new User(); // user.setUserId(100);
				user.setUserId(resultSet.getInt("user_id")); // getInt("columnName") gives the value from the specific column of int
				user.setName(resultSet.getString("name")); 
				user.setPassword(resultSet.getString("password"));
				user.setPhone(resultSet.getLong("phone"));
				System.out.println(user);
			}
			// 5th step is to close the resources
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
