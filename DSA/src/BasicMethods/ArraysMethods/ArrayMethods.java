package BasicMethods.ArraysMethods;

import java.util.Arrays;

public class ArrayMethods {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};

        // 1. Sort an array
        Arrays.sort(arr); // O(n log n)
        System.out.println("Sorted: " + Arrays.toString(arr));

        // 2. Binary search (must be sorted)
        int idx = Arrays.binarySearch(arr, 7);
        System.out.println("Index of 7: " + idx);

        // 3. Fill entire array with a value
        int[] filled = new int[5];
        Arrays.fill(filled, 1);
        System.out.println("Filled: " + Arrays.toString(filled));

        // 4. Compare arrays
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println("Equal? " + Arrays.equals(a, b));

        // 5. Copy arrays
        int[] copy = Arrays.copyOf(arr, arr.length);
        System.out.println("Copied: " + Arrays.toString(copy));

        
    }
}
