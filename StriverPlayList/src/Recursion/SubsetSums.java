package Recursion;

import java.util.*;

public class SubsetSums {
    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        combinations(arr, 0, 0, res);
        return res;
    }
    
    static void combinations(int[] arr, int idx, int sum, ArrayList<Integer> res) {
        if (idx == arr.length) {
            res.add(sum);
            return;
        }
        
        combinations(arr, idx + 1, sum + arr[idx], res);
        combinations(arr, idx + 1, sum, res);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

        ArrayList<Integer> ans = subsetSums(arr);
        Collections.sort(ans);

        for (int value : ans) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
