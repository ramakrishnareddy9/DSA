/*
 * QUESTION: Rod Cutting Problem
 * Given a rod of length n and array prices of length n denoting the cost of pieces of the rod of length 1 to n,
 * find the maximum amount that can be made if the rod is cut up optimally.
 * A rod cannot exceed length n.
 */
package DynammicProgrammingOneDimensional;

import java.util.Arrays;

public class RodCutting {
    static int rodCutting(int n, int prices[]) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, prices[i] + rodCutting(n - i, prices));
        }
        return ans;
    }

    static int[] DP;

    static int rodCutting_Memoization(int n, int prices[]) {
        if (n == 0) {
            return 0;
        }
        if (DP[n] != -1) {
            return DP[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, prices[i] + rodCutting_Memoization(n - i, prices));
        }
        return DP[n] = ans;
    }

    static int rodCutting_Tabulation(int n, int prices[]) {
        int[] DP = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                DP[i] = Math.max(DP[i], prices[j] + DP[i - j]);
            }
        }
        return DP[n];
    }

    public static void main(String[] args) {
        int n = 8;
        int prices[] = { 0, 1, 3, 4, 5, 7, 9, 10, 11 };// dont include 0 we kept zero for better undestanding to
                                                       // remove0based indexing to 1 based indexing so loops are running
                                                       // from 1
        System.out.println("Recursive: " + rodCutting(n, prices));
        DP = new int[n + 1];
        Arrays.fill(DP, -1);
        System.out.println("Memoization: " + rodCutting_Memoization(n, prices));
        System.out.println("Tabulation: " + rodCutting_Tabulation(n, prices));
    }
}
