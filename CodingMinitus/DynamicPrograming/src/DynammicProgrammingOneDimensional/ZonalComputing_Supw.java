/*
 * QUESTION: Zonal Computing - SUPW (Olympiad 2014)
 * In ICO School, all students have to participate regularly in SUPW. There is a different SUPW activity each day,
 * and each activity has its own duration. The SUPW schedule for the next term has been announced, including information about the number of minutes taken by each activity.
 * Nikhil has been designated SUPW coordinator. His task is to assign SUPW duties to students, including himself.
 * The school's rules say that no student can go three days in a row without any SUPW duty.
 * Nikhil wants to find an assignment of SUPW duty for himself that minimizes the number of minutes he spends overall on SUPW.
 */
package DynammicProgrammingOneDimensional;

import java.util.*;

public class ZonalComputing_Supw {
    static int supw_Tabulation(int a[]) { // explained
        int dp[] = new int[a.length];
        dp[0] = a[0];
        dp[1] = a[1];
        dp[2] = a[2];

        for (int i = 3; i < a.length; i++) {
            dp[i] = a[i] + Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        }
        return Math.min(dp[a.length - 1], Math.min(dp[a.length - 2], dp[a.length - 3]));
    }

    static int supwRecursive(int[] a, int index, int[] memo) {
        if (index < 0)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int option1 = supwRecursive(a, index - 1, memo);
        int option2 = supwRecursive(a, index - 2, memo);
        int option3 = supwRecursive(a, index - 3, memo);
        return memo[index] = a[index] + Math.min(option1, Math.min(option2, option3));
    }

    static int supw_Memoization(int[] a) {
        int n = a.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(supwRecursive(a, n - 1, memo), Math.min(supwRecursive(a, n - 2, memo), supwRecursive(a, n - 3, memo)));
    }

    public static void main(String[] args) {
        int a[] = { 3, 2, 3, 2, 3, 1, 5, 3 };
        System.out.println(supw_Tabulation(a));
        System.out.println(supw_Memoization(a));
    }
}
