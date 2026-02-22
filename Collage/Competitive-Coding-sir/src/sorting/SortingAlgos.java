package sorting;
import java.util.Arrays;
public class SortingAlgos {
	static void swap(int[] arr, int first, int second) {
		int temp=arr[first];
		arr[first] =arr[second];
		arr[second] = temp;
	}
	static void bubbleSort(int[] arr) {
		int steps=0,swaps=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				steps+=1;
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
					swaps+=1;
				}
			}
		}
		System.out.println("steps: "+steps);
		System.out.println("swaps: "+swaps);
	}
	static void optimizedBubbleSort(int[] arr) {
		int steps=0,swaps=0;
		boolean isSwapped;
		for(int i=0;i<arr.length;i++) {
			isSwapped=false;
			for(int j=0;j<arr.length-1;j++) {
				steps+=1;
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
					isSwapped = true;
					swaps+=1;
				}
			}
			if(!isSwapped)
				break;
		}
		System.out.println("steps: "+steps);
		System.out.println("swaps: "+swaps);
	}
	static void selectionSort(int[] arr) {
		int steps=0,swaps=0;
		for(int i=0;i<arr.length-1;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				steps++;
				if(arr[j]<arr[min])
					min=j;
			}
			if(i!=min) {
				swap(arr,i,min);
				swaps++;
			}
		}
		System.out.println("steps: "+steps);
		System.out.println("swaps: "+swaps);
	}
	static void insertionSort(int[] arr) {
		int steps=0;
		for(int i=1;i<arr.length;i++) {
			steps++;
			int j=i-1;
			int key = arr[i];
			while(j>=0 && arr[j]>key) {
				steps++;
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		System.out.println("steps: "+steps);
	}
	static void merge(int[] arr, int l, int mid, int r) {
		int n1=mid-l+1,n2=r-mid;
		int[] left = new int[n1];
		int[] right = new int[n2];
		for(int i=0;i<n1;i++) {
			left[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			right[j] = arr[mid+j+1];
		}
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(left[i]<=right[j])
				arr[k++] = left[i++];
			else
				arr[k++]=right[j++];
		}
		while(i<n1) {
			arr[k++]=left[i++];
		}
		while(j<n2) {
			arr[k++]=right[j++];
		}
	}
	static void mergeSortHelper(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			mergeSortHelper(arr, l, mid);
			mergeSortHelper(arr, mid+1, r);
			merge(arr,l,mid,r);
		}
	}
	static void mergeSort(int[] arr) {
		mergeSortHelper(arr,0,arr.length-1);
	}
	static void quickSortHelper(int[] arr, int start, int end){
		if(start>=end) return;
		int l=start,r=end;
		int mid = (l+r)/2;
		int pivot=arr[mid];
		while(l<=r) {
			while(arr[l]<pivot) {l++;}
			while(arr[r]>pivot) {r--;}
			if(l<=r) {
				swap(arr, l, r);
				l++;r--;
			}
		}
		quickSortHelper(arr,start,r);
		quickSortHelper(arr,l,end);
	}
	static void quickSort(int[] arr){
		quickSortHelper(arr,0,arr.length-1);
	}
	public static void main(String[] args) {
		int[] arr = {4,1,3,2,8,6,5,7};
		//bubbleSort(arr);
		//System.out.println(Arrays.toString(arr));
		//System.out.println("=======================");
		int[] arr2 = {1,2,3,4,5,6,7,9,8};
		//optimizedBubbleSort(arr2);
		//System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr));
		//selectionSort(arr);
		//insertionSort(arr);
		//mergeSort(arr);
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}