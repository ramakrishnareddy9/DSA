package Searching;

import java.util.Arrays;

public class ExponentialSearch {
    static int exponentialSearch(int arr[],int n, int target) {
        if (arr[0] == target)
            return 0;
      
        int i = 1;
        while (i < n && arr[i] <= target)
            i = i*2;
      
        return Arrays.binarySearch(arr, i/2, Math.min(i, n-1), target);
    }
    
    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};
        int target = 10;
        int result = exponentialSearch(arr, arr.length, target);
        
        System.out.println((result < 0) ? "Element is not present in array" :"Element is present at index " + result);
    }
}