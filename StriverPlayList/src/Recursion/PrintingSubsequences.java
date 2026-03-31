package Recursion;

import java.util.*;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Print ALL SUBSEQUENCES of a given ARRAY or STRING.
 * A subsequence maintains relative order but doesn't need to be contiguous.
 * 
 * EXPLANATION:
 * Use RECURSION with BACKTRACKING.
 * At each index, decide: include element or exclude element.
 * When all indices processed, print/store current subsequence.
 * 
 * EXAMPLES:
 * Input: [1, 2, 3]
 * Output: [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
 * (total 2^n subsequences)
 * 
 * Input: "AB"
 * Output: "", "A", "B", "AB"
 * 
 * TIME: O(2^n), SPACE: O(n) recursion stack
 */
public class PrintingSubsequences {

    private static void printSubsequences(int index, int[] arr, List<Integer> list) {
        if (index == arr.length) {
            if (list.isEmpty()) {
                System.out.println("{}");
            } else {
                for (int value : list) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            return;
        }

        // Pick the current element.
        list.add(arr[index]);
        printSubsequences(index + 1, arr, list);

        // Do not pick the current element.
        list.remove(list.size() - 1);
        printSubsequences(index + 1, arr, list);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> ds = new ArrayList<>();
        printSubsequences(0, arr, ds);
    }
}
