package com.hsbc.collection;

import java.util.HashSet;
import java.util.Set;

public class StudentSetDemo {

	public static void main(String[] args) {
		Set<Student> set1 = new HashSet<Student>();
		set1.add(new Student(1, "Alex", "A"));
		set1.add(new Student(1, "Bruce", "C"));
		set1.add(new Student(2, "Mark", "A"));
		set1.add(new Student(3, "Sony", "B"));
		System.out.println("Size: "+set1.size());
		for(Student s : set1) {
			System.out.println(s);
		}
	}

}
