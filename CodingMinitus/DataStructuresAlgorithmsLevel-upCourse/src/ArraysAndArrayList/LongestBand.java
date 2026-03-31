package ArraysAndArrayList;

/*
Given an array containing N integers, find length of longest band.
A band is defined as a subsequence which can be re-ordered in such a manner all elements appear consecutive (i.e., with absolute difference of 1 between neighbouring elements).
A longest band is the band (subsequence) which contains maximum integers.
Input :
    [1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6]
Output :
    8
Explanation :
    Largest subset containing consecutive numbers is {0, 1, 2, 3, 4, 5, 6, 7}
*/

import java.util.*;

/*
 * Question:
 * Find the length of the longest band (longest set of consecutive integers) in an unsorted array.
 */
public class LongestBand {
    // Time : o(n) Space : o(n)
    static int longestBand(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }
        int Len = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int next = i;
                int count = 0;
                while (set.contains(next)) {
                    next++;
                    count++;
                }
                Len = Math.max(Len, count);
            }
        }
        return Len;
    }

    // Time : o(nlogn) Space : o(1)
    static int longestBand2(int[] arr) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int count = 1, maxCount = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1] + 1) {
                count++;
            } else if(arr[i] != arr[i - 1]) {
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 9, 3, 0, 18, 5, 1, 4, 10, 7, 12, 6};
        System.out.println(longestBand(arr));
    }
}