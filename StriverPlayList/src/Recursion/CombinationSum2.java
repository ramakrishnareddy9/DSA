package Recursion;

import java.util.*;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Find ALL UNIQUE COMBINATIONS that SUM to TARGET.
 * EACH ELEMENT CAN BE USED AT MOST ONCE.
 * Array MAY CONTAIN DUPLICATES.
 * No duplicate combinations in result.
 * 
 * EXPLANATION:
 * Sort array to group duplicates.
 * Use backtracking with duplicate skipping.
 * Skip nums[i] if nums[i] == nums[i-1] in same recursion level.
 * 
 * EXAMPLE:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
 * 
 * TIME: O(2^n), SPACE: O(n)
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    static void combinations(int[] arr, int target, int index,List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            list.add(arr[i]);
            combinations(arr, target - arr[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
