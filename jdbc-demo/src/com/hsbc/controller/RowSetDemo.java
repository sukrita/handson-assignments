package com.hsbc.controller;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {

	public static void main(String[] args) {
		try {
			RowSet rowset = RowSetProvider.newFactory().createJdbcRowSet();
			rowset.setUrl("jdbc:derby://localhost:1527/mydb");
			rowset.setUsername("kishor");
			rowset.setPassword("kishor123");
			// try to pass ? and get the values
			// select * from emp join address on id=id_ref where id=?
			rowset.setCommand("select * from emp join address on id=id_ref where id=?");
			rowset.setInt(1, 102);
		
			rowset.execute();
			while(rowset.next()) {
				System.out.println("Id = "+rowset.getInt("id"));
				System.out.println("Name = "+rowset.getString("name"));
				System.out.println("State = "+rowset.getString("state"));
				System.out.println("City = "+rowset.getString("city"));
				System.out.println("---------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
