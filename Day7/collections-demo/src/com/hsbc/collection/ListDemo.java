package com.hsbc.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		//List<String> list1 = new ArrayList<String>();
		List<String> list1 = new LinkedList<String>();
		list1.add("Hello");
		list1.add("Hi");
		list1.add("Welcome");
		list1.add("Thankyou");
		list1.add("AbcXyz");
		System.out.println("Size: "+list1.size());
		list1.remove("Welcome");
		for(String s : list1) {
			System.out.print(s+" ");
		}
		System.out.println();
		System.out.println("Item at 3rd index: "+list1.get(3));
		System.out.println("-------------------------");
		Iterator<String> iterator = list1.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			System.out.println("Item: "+item);
			if(item.equals("Hi")) {
				iterator.remove();
			}
		}
		System.out.println("--------------------");
		iterator = list1.iterator();
		while(iterator.hasNext()) {
			System.out.println("Item: "+iterator.next());
		}
	}
}
