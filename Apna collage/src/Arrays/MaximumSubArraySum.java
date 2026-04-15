package Arrays;

public class MaximumSubArraySum {
    // Kadane's Algorithm
    static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for(int i = 1;i < nums.length;i++){
            current = Math.max(nums[i],current + nums[i]);
            max = Math.max(current,max);
        }
        return max;
    }

    // prefix Sum
    static int maxSubArray1(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        prefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int minPrefix = prefix[0];
        int maxSum = Integer.MIN_VALUE;

        for (int j = 1; j <= n; j++) {
            maxSum = Math.max(maxSum, prefix[j] - minPrefix);
            minPrefix = Math.min(minPrefix, prefix[j]);
        }

        return maxSum;
    }
}
