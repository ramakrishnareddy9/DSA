package Arrays;

/*
Question: Next Permutation (Medium)
Given an array of integers nums, find the next lexicographically greater permutation of numbers.
If such arrangement is not possible (i.e., the array is in descending order), rearrange it as the lowest possible order (ascending order).
You must do this in-place and use only constant extra memory.

Example 1
Input: nums = [1,2,3]
Output: [1,3,2]

Example 2
Input: nums = [3,2,1]
Output: [1,2,3]

Example 3
Input: nums = [1,1,5]
Output: [1,5,1]

Constraints

1 <= nums.length <= 100
0 <= nums[i] <= 100
*/

import java.util.*;

public class NextPermutation {
    static void nextPermutation1(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    }

    static void nextPermutation2(int[] nums) {
        int i = nums.length - 1;

        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int j = nums.length - 1;

        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }

        swap(nums, i - 1, j);
        reverse(nums, i, nums.length - 1);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 4, 3, 0, 0};
        int[] b = {2, 1, 5, 4, 3, 0, 0};

        nextPermutation1(a);
        nextPermutation2(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
