package searching;

import java.util.ArrayList;

public class LinearSearch {
	static boolean linearSearch(String[] names, String target) {
		int steps=0;
		for(String name:names) {
			steps+=1;
			if(name==target) {
				System.out.println(steps);
				return true;
			}
		}
		System.out.println(steps);
		return false;
	}
	static boolean linearSearch(ArrayList<String> names, String target) {
		int steps=0;
		for(String name:names) {
			steps+=1;
			if(name==target) {
				System.out.println(steps);
				return true;
			}
		}
		System.out.println(steps);
		return false;
	}
	static int linearSearchPos(String[] names, String target) {
		int steps=0;
		for(int i=0;i<names.length;i++) {
			steps+=1;
			if(names[i]==target) {
				System.out.println("iters: "+steps);
				return i;
			}
		}
		System.out.println("iters: "+steps);
		return -1;
	}
	
	static ArrayList<Integer> findOccurences(String[] names,String target) {
		ArrayList<Integer> res = new ArrayList();
		for (int i = 0; i < names.length; i++) {
			if(names[i]==target)
				res.add(i);
		}
		return res;
	}
	static int evenDigitsNumbers(int[] arr) {
		int count =0;
		for(int num:arr) {
			if((num>=10 && num<=99)||(num>=1000 && num<=9999)||(num==100000))
				count+=1;
		}
		return count;
	}
	static int richestCustomerWealth(int[][] accounts) {
		int maxWealth=0;
		for(int cust=0;cust<accounts.length;cust++) {
			int curWealth=0;
			for(int bank=0;bank<accounts[cust].length;bank++) {
				curWealth += accounts[cust][bank];
			}
			if(curWealth>maxWealth)
				maxWealth=curWealth;
		}
		return maxWealth;
	}
	public static void main(String[] args) {
		String[] names = {"Priya","Venky","Imran","Priya","Gani","Venky","Chandra"};
		String target ="Raj";
		ArrayList<String> names2 = new ArrayList<String>();
		names2.add("Soumya");
		names2.add("Raj");
		names2.add("Vishnu");
		names2.add("Priya");
		names2.add("Peter");
		//System.out.println(linearSearchPos(names,target));
		//System.out.println(findOccurences(names,target));
		int[] arr = {12,234,2381,3456,1234,5683,6789,21344,100000};
		//System.out.println(evenDigitsNumbers(arr));
		int[][] arr2 = {{1,2,3},{3,2,1},{5,7,2}};
		System.out.println(richestCustomerWealth(arr2));
	}
}