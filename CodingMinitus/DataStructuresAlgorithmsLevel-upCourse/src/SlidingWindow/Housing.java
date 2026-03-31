package SlidingWindow;

import java.util.Arrays;

/*
Question: Housing

Along one side of a road there is a sequence of vacant plots of land.
Each plot has a non-zero area, so areas form an array A of size N.

You want to buy exactly K acres of land to build a house.
Find all segments of contiguous plots (subarrays) whose total area is exactly K.

Print each valid segment as: start_index end_index (0-based).

Example:
Input:
A = [1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2]
K = 8

Output:
2 5
4 6
5 9
*/

public class Housing {

    static void housingBruteForce(int[] a, int k) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == k) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    static void housingPrefixBinarySearch(int[] a, int k) {
        int n = a.length;
        int[] ps = new int[n];
        ps[0] = a[0];
        for (int i = 1; i < n; i++) ps[i] = ps[i - 1] + a[i];

        for (int j = 0; j < n; j++) {
            int target = ps[j] - k;

            if (target == 0) {
                System.out.println(0 + " " + j);
            }

            int idx = Arrays.binarySearch(ps, 0, j + 1, target);
            if (idx >= 0) {
                int start = idx + 1;
                if (start <= j) {
                    System.out.println(start + " " + j);
                }
            }
        }
    }

    static void housingSlidingWindow(int[] a, int k) {
        int n = a.length;
        int i = 0, j = 0, sum = 0;

        while (j < n) {
            sum += a[j];
            j++;

            while (sum > k && i < j) {
                sum -= a[i];
                i++;
            }

            if (sum == k) {
                System.out.println(i + " " + (j - 1));
            }
        }
    }

    public static void main(String[] args) {
        int[] plots = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1, 2};
        int k = 8;

        System.out.println("Brute Force:");
        housingBruteForce(plots, k);

        System.out.println("Prefix + Binary Search:");
        housingPrefixBinarySearch(plots, k);

        System.out.println("Sliding Window:");
        housingSlidingWindow(plots, k);
    }
}