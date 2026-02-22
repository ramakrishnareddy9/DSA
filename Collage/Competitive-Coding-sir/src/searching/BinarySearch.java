package searching;
public class BinarySearch {
	static boolean binarySearch1(int[] arr, int target) {
		int l=0,r=arr.length-1,steps=0;
		while(l<=r) {
			steps+=1;
			int mid = (l+r)/2;
			if(target==arr[mid]) {
				System.out.println("iters: "+steps);
				return true;
			}
			else if(target>arr[mid])
				l=mid+1;
			else
				r=mid-1;
		}
		System.out.println("iters: "+steps);
		return false;
	}
	static boolean binarySearch2(int[] arr, int target) {
		int l=0,r=arr.length-1,steps=0;
		while(l<=r) {
			steps+=1;
			int mid = (l+r)/2;
			if(target==arr[mid]) {
				System.out.println("iters: "+steps);
				return true;
			}
			else if(target>arr[mid])
				r=mid-1;
			else
				l=mid+1;
		}
		System.out.println("iters: "+steps);
		return false;
	}
	static boolean agnosticBinarySearch(int[] arr, int target) {
		int l=0,r=arr.length-1,steps=0;
		while(l<=r) {
			steps+=1;
			int mid = (l+r)/2;
			if(target==arr[mid]) {
				System.out.println("iters: "+steps);
				return true;
			}
			if(arr[0]<arr[arr.length-1]) {
				if(target>arr[mid])
					l=mid+1;
				else
					r=mid-1;
			}
			else {
				if(target>arr[mid])
					r=mid-1;
				else
					l=mid+1;
			}
		}
		System.out.println("iters: "+steps);
		return false;
	}
	static int agnosticBinarySearchPos(int[] arr, int target) {
		int l=0,r=arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(target==arr[mid])
				return mid;
			if(arr[0]<arr[arr.length-1]) {
				if(target>arr[mid])
					l=mid+1;
				else
					r=mid-1;
			}
			else {
				if(target>arr[mid])
					r=mid-1;
				else
					l=mid+1;
			}
		}
		return -1;
	}
	static int agnosticBinarySearchRec(int[] arr, int target) {
		int l=0,r=arr.length-1;
		while(l<=r) {
			int mid = (l+r)/2;
			if(target==arr[mid])
				return mid;
			if(arr[0]<arr[arr.length-1]) {
				if(target>arr[mid])
					l=mid+1;
				else
					r=mid-1;
			}
			else {
				if(target>arr[mid])
					r=mid-1;
				else
					l=mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,2,4,6,8,9,12,14,15};
		int[] arr2 = {15,13,10,9,7,5,3,2,1};
		int target = 19;
		System.out.println(agnosticBinarySearchPos(arr2, target));
	}
}