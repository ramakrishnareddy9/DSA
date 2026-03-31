package Recursion.DivideAndConqure;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Count the number of INVERSIONS in an array.
 * An inversion is a pair (i, j) where i < j and arr[i] > arr[j].
 * Use Merge Sort based approach for O(n log n) solution.
 * 
 * EXPLANATION:
 * A naive approach would check all pairs: O(n^2).
 * Optimized: Use merge sort. Count inversions while merging:
 * - If left[i] > right[j], all remaining elements in left are inversions with right[j].
 * 
 * EXAMPLES:
 * Input: [1, 3, 5, 2, 4, 6]
 * Inversions: (3,2), (5,2), (5,4) = 3 inversions
 * 
 * Input: [5, 4, 3, 2, 1]
 * Output: 10 (maximum inversions for 5 elements)
 * 
 * Input: [1, 2, 3, 4]
 * Output: 0 (already sorted, no inversions)
 * 
 * TIME COMPLEXITY: O(n log n) - merge sort based
 * SPACE COMPLEXITY: O(n) - temporary arrays for merging
 */
public class InversionCount {
	static int inversionCountBruteForce(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

	static int merge(int[] arr, int start, int end) {
		int mid = (start + end) / 2;
		int i = start;
		int j = mid + 1;
		int k = start;

		int[] temp = new int[end - start + 1];

		int cnt = 0;

		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				cnt += mid - i + 1;
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= end) {
			temp[k++] = arr[j++];
		}

		for (i = start, k = 0; i <= end; i++, k++) {
			arr[i] = temp[k];
		}

		return cnt;
	}

	static int inversionCountUsingMergeSort(int[] a, int start, int end) {
		if (start >= end) {
			return 0;
		}

		int mid = (start + end) / 2;
		int x = inversionCountUsingMergeSort(a, start, mid);
		int y = inversionCountUsingMergeSort(a, mid + 1, end);
		int z = merge(a, start, end);

		return x + y + z;
	}

	public static void main(String[] args) {
		int[] arr1 = {5, 3, 2, 1, 4};
		int[] arr2 = {5, 3, 2, 1, 4};

		System.out.println("Brute Force: " + inversionCountBruteForce(arr1));
		System.out.println("Optimized (Merge Sort): " + inversionCountUsingMergeSort(arr2, 0, arr2.length - 1));
	}
}
