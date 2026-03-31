package Arrays;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for(int i = 1;i < nums.length;i++){
            current = Math.max(nums[i],current + nums[i]);
            max = Math.max(current,max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubArray solver = new MaximumSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solver.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}
