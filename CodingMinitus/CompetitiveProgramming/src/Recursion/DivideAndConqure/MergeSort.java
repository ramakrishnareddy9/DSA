package Recursion.DivideAndConqure;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Sort an array using MERGE SORT (Divide & Conquer approach).
 * 
 * EXPLANATION:
 * Divide & Conquer Strategy:
 * 1. DIVIDE: Split array into two halves recursively
 * 2. CONQUER: Sort each half recursively
 * 3. MERGE: Merge two sorted halves in O(n)
 * 
 * ALGORITHM:
 * mergeSort(arr, start, end):
 *   if start < end:
 *     mid = (start + end) / 2
 *     mergeSort(arr, start, mid)
 *     mergeSort(arr, mid+1, end)
 *     merge(arr, start, mid, end)
 * 
 * EXAMPLES:
 * Input: [64, 34, 25, 12, 22, 11, 90]
 * Output: [11, 12, 22, 25, 34, 64, 90]
 * 
 * TIME COMPLEXITY: O(n log n) - always
 * SPACE COMPLEXITY: O(n) - temporary arrays
 * STABLE: Yes (preserves order of equal elements)
 */
public class MergeSort {
	static void merge(int[] arr, int s, int e) {
		int mid = (s + e) / 2;

		int i = s;
		int j = mid + 1;
		int k = 0;

		int[] temp = new int[e - s + 1];

		while (i <= mid && j <= e) {
			if (arr[i] < arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= e) {
			temp[k++] = arr[j++];
		}

		for (i = s, k = 0; i <= e; i++, k++) {
			arr[i] = temp[k];
		}
	}

	static void mergeSort(int[] arr, int s, int e) {
		if (arr == null || s >= e) {
			return;
		}

		int mid = (s + e) / 2;

		mergeSort(arr, s, mid);
		mergeSort(arr, mid + 1, e);

		merge(arr, s, e);
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
		int[] arr = {5, 2, 8, 1, 3, 7};
		mergeSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
}
