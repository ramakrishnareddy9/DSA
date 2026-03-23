package Recursion;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinations(candidates, target, 0, new ArrayList<>(), res);
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
            combinations(arr, target - arr[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
