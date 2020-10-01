package com.hsbc.controller;

import java.time.LocalDate;

public class DateDemo {
	public static void main(String[] args) {
		// current date
		LocalDate today = LocalDate.now();
		LocalDate anotherDate = LocalDate.parse("2008-10-25"); // this should be the format
		
		System.out.println(today);
		System.out.println(anotherDate);
	}
}
