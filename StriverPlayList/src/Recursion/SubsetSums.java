package Recursion;

import java.util.*;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Generate ALL POSSIBLE SUBSET SUMS from given ARRAY.
 * Return SORTED list of all subset sums (including 0 for empty subset).
 * 
 * EXPLANATION:
 * For each element: 2 choices - include or exclude.
 * Total 2^n subsets, each with a unique or repeated sum.
 * 
 * ALGORITHM:
 * Recursion: For each index, generate sums with/without current element.
 * 
 * EXAMPLE:
 * Input: [1, 2, 3]
 * Subsets: [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
 * Sums: 0, 1, 2, 3, 3, 4, 5, 6
 * Output: [0, 1, 2, 3, 3, 4, 5, 6]
 * 
 * TIME: O(2^n), SPACE: O(2^n)
 */
public class SubsetSums {
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        combinations(arr, 0, 0, res);
        return res;
    }
    
    static void combinations(int[] arr, int idx, int sum, ArrayList<Integer> res) {
        if (idx == arr.length) {
            res.add(sum);
            return;
        }
        
        combinations(arr, idx + 1, sum + arr[idx], res);
        combinations(arr, idx + 1, sum, res);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

        ArrayList<Integer> ans = subsetSums(arr);
        Collections.sort(ans);

        for (int value : ans) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
