package Recursion.DivideAndConqure;
/*
Question : (i < j and a[i] > a[j]) all pairs
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
