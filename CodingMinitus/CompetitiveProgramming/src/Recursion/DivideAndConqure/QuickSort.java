package Recursion.DivideAndConqure;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Sort an array using QUICK SORT (Divide & Conquer approach).
 * 
 * EXPLANATION:
 * Quick Sort selects a PIVOT and partitions around it.
 * 1. Pick a pivot element
 * 2. Partition: elements < pivot go left, > pivot go right
 * 3. Recursively sort left and right partitions
 * 
 * PIVOT SELECTION STRATEGIES:
 * - First element, Last element, Random, Median-of-three
 * 
 * EXAMPLES:
 * Input: [64, 34, 25, 12, 22, 11, 90]
 * Pivot = 12
 * After partition: [...elements < 12..., 12, ...elements > 12...]
 * Output: [11, 12, 22, 25, 34, 64, 90]
 * 
 * TIME COMPLEXITY:
 * - Best/Average: O(n log n)
 * - Worst: O(n^2) if pivot always divides unevenly
 * SPACE COMPLEXITY: O(log n) - recursion stack
 * STABLE: No (not stable by default)
 */
public class QuickSort {
    static int partition(int[] arr, int s, int e) {
        if (arr == null || s >= e) {
            return s;
        }

        int pivot = arr[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[e];
        arr[e] = temp;

        return i + 1;
    }

    static void quickSort(int[] arr, int s, int e) {
        if (arr == null || s >= e) {
            return;
        }

        int pi = partition(arr, s, e);

        quickSort(arr, s, pi - 1);
        quickSort(arr, pi + 1, e);
    }

    static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i + 1 < arr.length ? " " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3, 7};
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
