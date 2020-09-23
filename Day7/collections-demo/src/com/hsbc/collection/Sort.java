package com.hsbc.collection;

import java.util.Comparator;

public class Sort {
	
	class SortByItemId implements Comparator<Item>{
		
		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o1.getItemId() - o2.getItemId();
		}
	}
	
	class SortByItemName implements Comparator<Item>{ 
		
		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
			
		}
		
	}
	 
	class SortByItemPrice implements Comparator<Item>{ 
		
		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)o1.getPrice() - (int)o2.getPrice();
		}
	}
	
	class SortByRatings implements Comparator<Item>{
		
		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)o1.getRatings() - (int)o2.getRatings();
		}
		
	}

	

}
