package ArraysAndArrayList;

/*
Given an array of size at-least two, find the smallest subarray that needs to be sorted in place so that entire input array becomes sorted.
If the input array is already sorted, the function should return [-1, -1], otherwise return the start & end index of smallest subarray.

Sample Input :
    a1 = [1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11]

Sample Output :
    [5, 7]
*/

import java.util.*;

public class SubarraySort {
    // to identify the base case
    static boolean outOfOrder(int arr[], int i) {
        
        if (i == 0) {
            return arr[i] > arr[1];
        }
        if (i == arr.length - 1) {
            return arr[i] < arr[i - 1];
        }
        return arr[i] > arr[i + 1] || arr[i] < arr[i - 1];
    }

    static List<Integer> subarraySort(int arr[]) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (outOfOrder(arr, i)) {
                smallest = Math.min(smallest, arr[i]);
                largest = Math.max(largest, arr[i]);
            }
        }

        if (smallest == Integer.MAX_VALUE) {
            return Arrays.asList(-1, -1);
        }

        int left = 0;
        while (left < arr.length && arr[left] <= smallest) {
            left++;
        }

        int right = arr.length - 1;
        while (right >= 0 && arr[right] >= largest) {
            right--;
        }

        return Arrays.asList(left, right);
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};
        System.out.println(subarraySort(a1));
    }
}
