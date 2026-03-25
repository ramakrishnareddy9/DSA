package Recursion;

public class RecursionArrayisSorted {
    static boolean isSorted(int[] arr, int start) {
        if (arr == null || arr.length <= 1 || start >= arr.length - 1) {
            return true;
        }

        if (arr[start] < arr[start + 1] && isSorted(arr, start + 1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 14, 5};
        System.out.println(isSorted(arr, 0));
    }
}
