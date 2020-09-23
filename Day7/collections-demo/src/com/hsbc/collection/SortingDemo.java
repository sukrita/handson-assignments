package com.hsbc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {

	public static void main(String[] args) {
/*		List<Student> list = new ArrayList<Student>();
		list.add(new Student(5, "Zaheer", "A"));
		list.add(new Student(3, "Charles", "B"));
		list.add(new Student(4, "Bruce", "C"));
		list.add(new Student(2, "Edward", "A"));
		list.add(new Student(1, "David", "B"));
		for(Student s : list) {System.out.println(s);}
//		Collections.sort(list); // this uses compareTo method of Student class 
		System.out.println("---- after sorting ----");
		for(Student s : list) {System.out.println(s);}
		System.out.println("--- after sorting ---");
		// another overloaded sort method, takes comparator object as a second parameter
//		Collections.sort(list, new SortStudentByRollNo());
		for(Student s : list) {System.out.println(s);}
		System.out.println("--- sort by name ---");
		// another overloaded sort method, takes comparator object as a second parameter
//		Collections.sort(list, new SortStudentByNameAscending());
		for(Student s : list) {System.out.println(s);}
*/		
		
		List<Item> item = new ArrayList<Item>();
		item.add(new Item(1, "Laptop", 50000, 4.5));
		item.add(new Item(2, "Television", 45000, 5));
		item.add(new Item(3, "Charger", 2000, 3.0));
		item.add(new Item(4, "iPad", 50000, 4.5));
		item.add(new Item(5, "Earphones", 3000, 2.3));
		
		for(Item i : item) {System.out.println(i);}
		
		Sort s = new Sort();
		
		Collections.sort(item, s.new SortByItemId());
		System.out.println("---- after sorting by Item Id ----");
		for(Item i : item) {System.out.println(i);}
		Collections.sort(item, s.new SortByItemName());
		System.out.println("---- after sorting by Item Name ----");
		for(Item i : item) {System.out.println(i);}
		Collections.sort(item, s.new SortByItemPrice());
		System.out.println("---- after sorting by Item Price ----");
		for(Item i : item) {System.out.println(i);}
		Collections.sort(item, s.new SortByRatings());
		System.out.println("---- after sorting by Item Ratings ----");
		for(Item i : item) {System.out.println(i);}
		
		
		
		
		
	}

}
