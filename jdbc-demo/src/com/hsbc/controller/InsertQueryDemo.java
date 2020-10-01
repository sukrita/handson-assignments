package com.hsbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.hsbc.model.beans.User;
import com.hsbc.model.utility.DBUtility;

public class InsertQueryDemo {

	public static void main(String[] args)  {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement sequenceStatement = connection.prepareStatement("values(next value for user_seq)");
			ResultSet rs = sequenceStatement.executeQuery();
			int seq = 0;
			if(rs.next()) {
				seq = rs.getInt(1);
			} 
			if(seq == 0) {
				// throw some exception to the client
			} 
			
			PreparedStatement preparedStatement = 
					connection.prepareStatement("insert into user_table values(?,?,?,?)");
			preparedStatement.setInt(1, seq);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter name");
			preparedStatement.setString(2, scanner.next());
			System.out.println("Enter password");
			preparedStatement.setString(3, scanner.next());
			System.out.println("Enter phone");
			preparedStatement.setLong(4, scanner.nextLong());
			preparedStatement.executeUpdate();
			System.out.println("User created with an id = "+seq);
			preparedStatement.close();
			connection.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
