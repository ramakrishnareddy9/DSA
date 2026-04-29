package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumUnbounded {
    public static boolean isSubsetSum(int[] a, int target) {
        return solve(a, 0, target);
    }

    private static boolean solve(int[] a, int i, int target) {
        if (target == 0)
            return true;
        if (i == a.length || target < 0)
            return false;

        if (solve(a, i, target - a[i]))
            return true; // include
        if (solve(a, i + 1, target))
            return true; // exclude
        return false;
    }

    // print out
    static void printAllWays(int[] a, int target) {
        List<Integer> current = new ArrayList<>();
        solve(a, 0, target, current);
    }

    static void solve(int[] a, int i, int target, List<Integer> current) {
        if (target == 0) {
            System.out.println(new ArrayList<>(current));
            return;
        }

        if (i == a.length || target < 0)
            return;

        current.add(a[i]);
        solve(a, i, target - a[i], current); // include
        current.remove(current.size() - 1);

        solve(a, i + 1, target, current); // exclude
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 7 };
        int target = 14;
        System.out.println(isSubsetSum(a, target));
        printAllWays(a, target);
    }
}
