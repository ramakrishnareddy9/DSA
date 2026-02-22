package BasicMethods.ArraysMethods;

import java.util.Arrays;
import java.util.Collections;

public class SortMethod {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7};

        // 1. Sort entire array (ascending)
        Arrays.sort(arr); 
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 7, 9]

        // 2. Sort a subarray (from index 1 to 4, exclusive of 4)
        int[] arr2 = {10, 5, 3, 8, 6};
        Arrays.sort(arr2, 1, 4);
        System.out.println(Arrays.toString(arr2)); // [10, 3, 5, 8, 6]

        // 3. Sort in reverse order (ONLY for objects, not primitives)
        Integer[] arr3 = {5, 2, 9, 1, 7};
        Arrays.sort(arr3, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr3)); // [9, 7, 5, 2, 1]

        // 4. Custom comparator (sort strings by length)
        String[] names = {"Rama", "Krishna", "Reddy"};
        Arrays.sort(names, (a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println(Arrays.toString(names)); // [Rama, Reddy, Krishna]

        // 5. Parallel sort -> Uses divide-and-conquer + multithreading (ForkJoinPool)
        int[] arr4 = {9, 7, 6, 3, 1};
        Arrays.parallelSort(arr4);
        System.out.println(Arrays.toString(arr4)); // [1, 3, 6, 7, 9]
    }
}
