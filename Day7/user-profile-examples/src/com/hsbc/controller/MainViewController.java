package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.UserNotFoundException;
import com.hsbc.model.beans.User;
import com.hsbc.model.business.UserService;
import com.hsbc.model.utility.Type;
import com.hsbc.model.utility.UserFactory;

public class MainViewController {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		// This is getting service object
		UserService service = (UserService) UserFactory.getInstance(Type.SERVICE);
		int option = 0;
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Find User by id 4: Update PhoneNo. 5: Update Password 6: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				User user = new User();
				System.out.println("Enter name");		
				user.setName(scanner.next());
//				String name = scanner.next();
//				user.setName(name);
				
				System.out.println("Enter password");	
				user.setPassword(scanner.next());
				System.out.println("Enter phone no");	
				user.setPhone(scanner.nextLong());
				User createdUser = service.storeUser(user);
				System.out.println("User created with an id: "+createdUser.getUserId());
				break;
			case 2: 
				User[] users = service.getAllUsers();
				for(User temp : users) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				System.out.println("Enter user id");
				try {
					User userFound = service.fetchUserById(scanner.nextInt());
					// print on different device
					System.out.println(userFound);
				} catch (UserNotFoundException e) {
					// print error on different device
					System.err.println("ERROR:"+e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter user id");
				int userId = scanner.nextInt();
				System.out.println("Enter phone no");
				long phone = scanner.nextLong();
				try {
					User userUpdatePhone = service.updatePhoneNo(userId, phone);
					System.out.println(userUpdatePhone);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR: "+ e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter user id");
				int id = scanner.nextInt();
				System.out.println("Enter password no");
				String password = scanner.next();
				try {
					User userUpdatePassword = service.updatePassword(id, password);
					System.out.println(userUpdatePassword);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println("ERROR: "+ e.getMessage());
				}
				break;
				
				
				
			}
		} while(option != 6);
		
		scanner.close();
	}

}
