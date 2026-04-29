/*
 * QUESTION: Subset Sum Problem
 * Given a SUM and an array of non-negative numbers, determine if a subset of the array exists with sum equals to the given SUM.
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {
    public static boolean isSubsetSum(int[] a, int target) {
        return solve(a, 0, 0, target);
    }

    static boolean solve(int[] a, int i, int total, int target) {
        if (total == target)
            return true;
        if (i == a.length || total > target)
            return false;

        if (solve(a, i + 1, total + a[i], target))
            return true;
        if (solve(a, i + 1, total, target))
            return true;

        return false;
    }

    // print output
    public static void findSubsets(int[] a, int target) {
        List<Integer> current = new ArrayList<>();
        solve(a, 0, target, current);
    }

    private static void solve(int[] a, int i, int target, List<Integer> current) {
        if (target == 0) {
            System.out.println(current);
            return;
        }

        if (i == a.length || target < 0)
            return;

        current.add(a[i]);
        solve(a, i, target - a[i], current);
        current.remove(current.size() - 1);

        solve(a, i + 1, target, current);
    }

    public static void main(String[] args) {
        int[] a = { 3, 34, 4, 12, 5, 2 };
        int target = 9;
        System.out.println(isSubsetSum(a, target));
        findSubsets(a, target);
    }
}
