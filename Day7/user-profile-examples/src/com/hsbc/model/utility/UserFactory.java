package com.hsbc.model.utility;

import com.hsbc.model.business.UserServiceImpl;
import com.hsbc.model.dao.ArrayBackedUserDao;
import com.hsbc.model.dao.CollectionBackedArrayUserDao;


public class UserFactory {
	// it can return dao, service or controller instance
	
	
	public static Object getInstance(Type type) {
		Object obj = null;
		switch(type) {
		case DAO : 
			obj = new ArrayBackedUserDao();
			break;
		case SERVICE :
			obj = new UserServiceImpl();
			break;
		case COLDAO :
			obj = new CollectionBackedArrayUserDao();
			break;
		}
		return obj;
	}
}
