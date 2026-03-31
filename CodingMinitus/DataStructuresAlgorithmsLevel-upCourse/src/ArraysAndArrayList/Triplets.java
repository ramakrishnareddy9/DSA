package ArraysAndArrayList;

/*
Given an array containing N integers, and an number S denoting a target sum.
Find all distinct integers that can add up to form target sum. The numbers in each triplet should be ordered in ascending order, and triplets should be ordered too. Return empty array if no such triplet exists.
Input
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 15]
    target = 18
Output
    [[1, 2, 15],
    [3, 7, 8],
    [4, 6, 8],
    [5, 6, 7]]
*/

import java.util.*;

/*
 * Question:
 * Find triplets in the array that satisfy the required target condition.
 */
public class Triplets {
    // Time : n log n + n^2  space : o(1)
    static List<List<Integer>> triplites(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == target) {
                    res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    // Time : n log n + n^2  space : o(n)
    static List<List<Integer>> triplites2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int diff = target - arr[i] - arr[j];
                if (map.containsKey(diff)) {
                    res.add(Arrays.asList(arr[i], diff, arr[j]));
                    while (j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
                }
                map.put(arr[j], j);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        int target = 18;
        System.out.println(triplites(array, target));
    }
}
