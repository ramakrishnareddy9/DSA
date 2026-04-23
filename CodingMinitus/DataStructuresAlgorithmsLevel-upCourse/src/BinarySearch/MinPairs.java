package BinarySearch;

/*
Given two non-empty arrays, find the pairs of numbers(one from each array) whose absolute difference is minimum. Print the any one pairs with the smallest difference

Input:
    a1 = [-1,5,10,20,3]
    a2 = [26,134,135,15,17]
Output :
    [20,17]
*/

import java.util.*;

public class MinPairs {
    static ArrayList<Integer> minPair(int[] a1, int[] a2) {
        Arrays.sort(a2);

        int minDiff = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : a1) {
            int idx = lowerBound(a2, num);
            if (idx < a2.length) {
                int diff = Math.abs(num - a2[idx]);
                if (diff < minDiff) {
                    minDiff = diff;
                    result.clear();
                    result.add(num);
                    result.add(a2[idx]);
                }
            }

            if (idx > 0) {
                int diff = Math.abs(num - a2[idx - 1]);
                if (diff < minDiff) {
                    result.clear();
                    result.add(num);
                    result.add(a2[idx - 1]);
                }
            }
        }
        return result;
    }

    static int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] a1 = {-1, 5, 10, 20, 3};
        int[] a2 = {26, 134, 135, 15, 17};

        ArrayList<Integer> res = minPair(a1, a2);
        System.out.println(res);
    }
}