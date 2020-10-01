package com.hsbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.hsbc.model.utility.DBUtility;

public class RsMdDemo {

	public static void main(String[] args) {
		try {
			Connection connection = DBUtility.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table");
			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			System.out.println("Colum Name at 3rd index: "+resultSetMetaData.getColumnName(3));
			System.out.println("Column Count: "+resultSetMetaData.getColumnCount());
			System.out.println("Column Type at 3rd index: "+resultSetMetaData.getColumnTypeName(3));
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
