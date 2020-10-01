package com.hsbc.model.util;


import com.hsbc.model.dao.JdbcBackedUserDaoImpl;
import com.hsbc.model.service.UserServiceImpl;
import com.hsbc.model.util.Type;

public class UserFactory {
	
	public static Object getInstance(Type type) {
		Object obj = null;
		switch(type) {
		case DAO : 
			obj = new JdbcBackedUserDaoImpl();
			break;
		case SERVICE :
			obj = new UserServiceImpl();
			break;

		}
		return obj;
	}

}
