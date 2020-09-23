package com.hsbc.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		//Set<Integer> set1 = new HashSet<Integer>();
		//Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set1 = new LinkedHashSet<Integer>();
		set1.add(35);
		set1.add(25);
		set1.add(30);
		set1.add(20);
		set1.add(50);
		set1.add(45);
		set1.add(45);
		System.out.println("Size: "+set1.size());
		for(int item : set1) {
			System.out.print(item +" ");
		}
		System.out.println();
		
	}

}
