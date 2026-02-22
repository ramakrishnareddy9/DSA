package recursion;

import java.util.ArrayList;

public class RecursionPractice {
	static boolean sortHelper(int[] arr, int ind) {
		if(ind==arr.length)	return true;
		if(arr[ind] < arr[ind-1])	return false;
		return sortHelper(arr, ind+1);
	}
	static boolean isSorted(int[] arr) {
		return sortHelper(arr,1);
	}
	static int countHelper(int num,int steps) {
		if(num==0)	
			return steps;
		if(num%2==0)
			return countHelper(num/2, steps+1);
		return countHelper(num-1, steps+1);
	}
	static int countSteps(int num) {
		return countHelper(num,0);
	}
	
	
	static boolean PowerOfTwo(int n) {
		if(n == 0) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		if(n % 2 != 0) {
			return false;
		}
		return PowerOfTwo(n/2);
	}
	static int winnerCircularGame(int[] arr,int k) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
			nums.add(i);
		int idx = 0;
		while(nums.size()>1) {
			idx = (idx+(k-1))%nums.size();
			nums.remove(idx);
		}
		return nums.get(0)+1;
	}
	public static void main(String[] args) {
		//int[] arr = {1,2,4,3,7,9};
		//System.out.println(isSorted(arr));
		//System.out.println(countSteps(3));
		//System.out.println(PowerOfTwo(18));
		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.println(winnerCircularGame(arr, 3));
	}
}







