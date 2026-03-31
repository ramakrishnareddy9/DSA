package Recursion.Basic;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Sort the given array using RECURSIVE bubble sort (not iterative).
 * 
 * EXPLANATION:
 * Bubble sort moves the largest element to the end in each pass.
 * Recursive approach: In each recursive call, bubbles largest to end, then recurse on remaining.
 * 
 * ALGORITHM:
 * 1. Compare adjacent elements
 * 2. Swap if arr[j] > arr[j+1]
 * 3. Recurse for n-1 elements
 * 4. Base case: when n <= 1
 * 
 * EXAMPLES:
 * Input: [64, 34, 25, 12, 22]
 * Output: [12, 22, 25, 34, 64]
 * 
 * COMPLEXITY:
 * TIME: O(n^2) - still quadratic despite recursion
 * SPACE: O(n) - recursion call stack
 */
public class BubbleSort {
	static void bubbleSort(int[] arr, int n) {
		if (arr == null || n <= 1) {
			return;
		}

		for (int j = 0; j < n - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		bubbleSort(arr, n - 1);
	}

	static void bubbleSortRecursive(int[] arr, int idx, int n) {
		if (arr == null || n <= 1) {
			return;
		}

		if (idx == n - 1) {
			bubbleSortRecursive(arr, 0, n - 1);
			return;
		}

		if (arr[idx] > arr[idx + 1]) {
			int temp = arr[idx];
			arr[idx] = arr[idx + 1];
			arr[idx + 1] = temp;
		}

		bubbleSortRecursive(arr, idx + 1, n);
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
		int[] arr1 = {5, 4, 1, 3, 2};
		int[] arr2 = {5, 4, 1, 3, 2};

		bubbleSort(arr1, arr1.length);
		bubbleSortRecursive(arr2, 0, arr2.length);

		printArray(arr1);
		printArray(arr2);
	}

}
