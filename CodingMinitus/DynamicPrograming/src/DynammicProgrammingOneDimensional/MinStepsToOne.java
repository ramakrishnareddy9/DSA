/*
 * QUESTION: Minimum Steps to One (Minimum Number of Operations)
 * You are given a positive integer 'N'. You have to reduce it to one by performing following steps:
 * 1) Reduce it to n-1. (n => n-1)
 * 2) If it is divisible by 2, then divide it by 2. (n => n/2)
 * 3) If it is divisible by 3, then divide it by 3. (n => n/3)
 * Find the minimum number of operations to reduce N to 1.
 */
package DynammicProgrammingOneDimensional;

import java.util.Arrays;

public class MinStepsToOne {

    // both using Memoization

    static int[] memo;

    public static int dp(int n) {
        if (n == 1)
            return 0;
        if (memo[n] != -1)
            return memo[n];
        int ans = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            ans = Math.min(ans, dp(n / 2));
        }
        if (n % 3 == 0) {
            ans = Math.min(ans, dp(n / 3));
        }
        ans = Math.min(ans, dp(n - 1));
        memo[n] = ans + 1;
        return memo[n];
    }

    static int[] memo1;

    public static int dp1(int n) {
        if (n == 1)
            return 0;
        if (memo1[n] != -1)
            return memo1[n];
        memo1[n] = dp1(n - 1);
        if (n % 2 == 0) {
            memo1[n] = Math.min(memo1[n], dp1(n / 2));
        }
        if (n % 3 == 0) {
            memo1[n] = Math.min(memo1[n], dp1(n / 3));
        }
        return ++memo1[n];
    }

    public static void main(String[] args) {
        int n = 10;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        System.out.println(dp(n));
        memo1 = new int[n + 1];
        Arrays.fill(memo1, -1);
        System.out.println(dp1(n));
    }
}
