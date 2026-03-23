package Recursion;

import java.util.*;

class CombinationSum {

    // leetCode 
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    static void combinations(int[] arr, int target, int index, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target) continue;

            list.add(arr[i]);
            combinations(arr, target - arr[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }

    // cocde360 need to check for duplicates 
    /*
    public static List<List<Integer>> combSum(int[] ARR, int B) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(ARR);
        combinations(ARR, B, 0, new ArrayList<>(), res);
        return res;
    }

    static void combinations(int[] arr, int target, int index,List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            list.add(arr[i]);
            combinations(arr, target - arr[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }
    */
    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = combinationSum(candidates, target);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}