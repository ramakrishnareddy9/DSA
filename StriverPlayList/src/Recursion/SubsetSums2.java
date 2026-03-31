package Recursion;

import java.util.*;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Generate ALL UNIQUE SUBSETS from ARRAY with DUPLICATES.
 * Each unique subset appears only once (no duplicate subsets).
 * 
 * EXPLANATION:
 * Sort array to group duplicates together.
 * Use backtracking + duplicate skipping logic.
 * Skip when nums[i]==nums[i-1] in same recursion level.
 * 
 * ALGORITHM:
 * Sort -> Backtrack with proper i+1 and skip logic
 * 
 * EXAMPLE:
 * Input: [1, 2, 2]
 * Output: [[], [1], [1,2], [1,2,2], [2], [2,2]]
 * (no duplicates like [1,2] appearing twice)
 * 
 * TIME: O(2^n log n), SPACE: O(2^n)
 */
public class SubsetSums2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res) {
        res.add(new ArrayList<>(curr));

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            backtrack(nums, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        SubsetSums2 solver = new SubsetSums2();

        List<List<Integer>> result = solver.subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
