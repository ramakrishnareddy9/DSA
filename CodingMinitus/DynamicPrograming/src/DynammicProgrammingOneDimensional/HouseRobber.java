/*
 * QUESTION: House Robber (LeetCode 198)
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
package DynammicProgrammingOneDimensional;

import java.util.Arrays;

public class HouseRobber {
    static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int DP[] = new int[nums.length];
        DP[0] = nums[0];
        DP[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            DP[i] = Math.max(DP[i - 1], DP[i - 2] + nums[i]);
        }
        return Math.max(DP[nums.length - 1], DP[nums.length - 2]);
    }

    static int DP[];

    static int rob_tab(int[] nums) {
        DP = new int[nums.length];
        Arrays.fill(DP, -1);
        return helper(nums.length - 1, nums);
    }

    static int helper(int n, int cost[]) {
        if (n < 0) {
            return 0;
        }
        if (DP[n] != -1) {
            return DP[n];
        }
        DP[n] = Math.max(helper(n - 1, cost), helper(n - 2, cost) + cost[n]);
        return DP[n];
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 1 };
        System.out.println(rob(a));
        System.out.println(rob_tab(a));
    }
}