package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumUnbounded {
    public static boolean isSubsetSum(int[] a, int target) {
        return solve(a, 0, target);
    }

    private static boolean solve(int[] a, int i, int target) {
        if (target == 0)
            return true;
        if (i == a.length)
            return false;

        if (target >= a[i]) {
            if (solve(a, i, target - a[i]))
                return true;
        }

        if (solve(a, i + 1, target))
            return true;

        return false;
    }

    // print output
    public static void printAllWays(int[] a, int target) {
        List<Integer> current = new ArrayList<>();
        solve(a, 0, target, current);
    }

    private static void solve(int[] a, int i, int target, List<Integer> current) {
        if (target == 0) {
            System.out.println(new ArrayList<>(current));
            return;
        }

        if (i == a.length)
            return;

        if (target >= a[i]) {
            current.add(a[i]);
            solve(a, i, target - a[i], current); // include, stay on i
            current.remove(current.size() - 1);
        }

        solve(a, i + 1, target, current); // exclude, go to i+1
    }

    public static void main(String[] args) {
        int[] a = { 2, 3, 7 };
        int target = 14;
        System.out.println(isSubsetSum(a, target));
        printAllWays(a, target);
    }
}
