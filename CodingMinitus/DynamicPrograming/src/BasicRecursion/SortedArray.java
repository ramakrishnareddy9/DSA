package BasicRecursion;

public class SortedArray {
    static boolean isSorted(int arr[], int n, int i) {
        if (i == n) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, n, i + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        System.out.println(isSorted(arr, arr.length - 1, 0));
    }
}
