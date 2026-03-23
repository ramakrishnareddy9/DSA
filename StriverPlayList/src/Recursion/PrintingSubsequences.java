package Recursion;

import java.util.*;

public class PrintingSubsequences {

    private static void printSubsequences(int index, int[] arr, List<Integer> list) {
        if (index == arr.length) {
            if (list.isEmpty()) {
                System.out.println("{}");
            } else {
                for (int value : list) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            return;
        }

        // Pick the current element.
        list.add(arr[index]);
        printSubsequences(index + 1, arr, list);

        // Do not pick the current element.
        list.remove(list.size() - 1);
        printSubsequences(index + 1, arr, list);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        List<Integer> ds = new ArrayList<>();
        printSubsequences(0, arr, ds);
    }
}