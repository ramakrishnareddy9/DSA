package searching;

import java.util.Arrays;

public class BinarySearchPractice {
	static int sqrt(int x) {
		if(x==0 || x==1)	
			return x;
		int l=0,r=x;
		while(l<=r) {
			int mid=(l+r)/2;
			long midSqr = (long) mid*mid;
			if(midSqr==x)
				return mid;
			else if(midSqr>x)
				r=mid-1;
			else
				l=mid+1;
		}
		return r;				
	}
	static int searchRotatedArray(int[] nums, int target) {
		int l=0,r=nums.length-1;
		while(l<=r) {
			int mid=(l+r)/2;
			if(target==nums[mid])
				return mid;
			if(nums[l]<=nums[mid]) {
				if(nums[l]<=target && target<=nums[r])
					r=mid-1;
				else
					l=mid+1;
			}
			else {
				if(nums[mid]<=target && target<=nums[r])
					l=mid+1;
				else
					r=mid-1;
			}
		}
		return -1;
	}
	static boolean searchRotatedArray2(int[] nums, int target) {
		int l=0,r=nums.length-1;
		while(l<=r) {
			int mid=(l+r)/2;
			if(target==nums[mid])
				return true;
			if(nums[l]==nums[mid] && nums[mid]==nums[r]) {
				l+=1;r-=1;continue;
			}
			if(nums[l]<=nums[mid]) {
				if(nums[l]<=target && target<=nums[r])
					r=mid-1;
				else
					l=mid+1;
			}
			else {
				if(nums[mid]<=target && target<=nums[r])
					l=mid+1;
				else
					r=mid-1;
			}
		}
		return false;
	}
	static boolean canWeArrange(int[] slots, int cows, int dist) {
		int last = slots[0],count=1;
		for(int i=1;i<slots.length;i++) {
			if((slots[i]-last) >= dist) {
				count++;
				last = slots[i];
			}
		}
		if(count>=cows)
			return true;
		return false;
	}
	static int aggressiveCows(int[] slots, int cows){
		int l=1;
		int maxDist = slots[slots.length-1]-slots[0],dist;
		int r= maxDist;
		while(l<=r) {
			int mid = (l+r)/2;
			if(canWeArrange(slots, cows, mid))
				l=mid+1;
			else
				r=mid-1;
		}
		return r;
		/*
		for(dist=1;dist<=maxDist;dist++) {
			if(canWeArrange(slots,cows,dist))
				continue;
			else
				break;
		}
		return dist-1;
		*/
	}
	public static void main(String[] args) {
		//System.out.println(sqrt(17));
		int[] arr = {3,3,3,3,3,1,3,3,3};
		int target = 15;
		//System.out.println(searchRotatedArray2(arr, target));
		int[] slots = {0,1,3,4,7,9,10};
		int cows = 3;
		int[] pos = {1,2,3,4,7};
		System.out.println(aggressiveCows(pos, cows));
	}
}












