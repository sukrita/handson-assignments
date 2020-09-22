package com.hsbc.model.utility;

import com.hsbc.model.dao.AccountBackedAccountDao;
import com.hsbc.model.service.AccountServiceImplementation;

public class AccountFactory {
	
	public static Object getInstance(Type type) {
		Object obj = null;
		switch(type) {
		case DAO : 
			obj = new AccountBackedAccountDao();
			break;
		case SERVICE :
			obj = new AccountServiceImplementation();
			break;
		}
		return obj;
	}

}
