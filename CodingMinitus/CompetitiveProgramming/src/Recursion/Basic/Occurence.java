package Recursion.Basic;

/*
 * Question:
 * Find the occurrence position(s) of a key in an array using recursion.
 */
public class Occurence {
	static int linearSearch(int[] arr, int key, int idx) {
		if (arr == null || idx == arr.length) {
			return -1;
		}
		if (arr[idx] == key) {
			return idx;
		}
		return linearSearch(arr, key, idx + 1);
	}

	static int firstOcc(int[] arr, int i, int key) {
		if (arr == null) {
			return -1;
		}
		if (i == arr.length) {
			return -1;
		}
		if (arr[i] == key) {
			return i;
		}
		return firstOcc(arr, i + 1, key);
	}

	static int lastOcc(int[] arr, int i, int key) {
		if (arr == null) {
			return -1;
		}
		if (i == arr.length) {
			return -1;
		}

		int idxInRest = lastOcc(arr, i + 1, key);
		if (idxInRest != -1) {
			return idxInRest;
		}
		if (arr[i] == key) {
			return i;
		}
		return -1;
	}

	static int secondOcc(int[] arr, int key) {
		if (arr == null) {
			return -1;
		}
		return secondOcc(arr, key, 0, 0);
	}

	private static int secondOcc(int[] arr, int key, int idx, int count) {
		if (idx == arr.length) {
			return -1;
		}

		int updatedCount = count;
		if (arr[idx] == key) {
			updatedCount++;
			if (updatedCount == 2) {
				return idx;
			}
		}
		return secondOcc(arr, key, idx + 1, updatedCount);
	}

	static int secondLastOcc(int[] arr, int key) {
		if (arr == null) {
			return -1;
		}
		return secondLastOcc(arr, key, arr.length - 1, 0);
	}

	private static int secondLastOcc(int[] arr, int key, int idx, int seenFromRight) {
		if (idx < 0) {
			return -1;
		}

		int updatedSeen = seenFromRight;
		if (arr[idx] == key) {
			updatedSeen++;
			if (updatedSeen == 2) {
				return idx;
			}
		}
		return secondLastOcc(arr, key, idx - 1, updatedSeen);
	}

	static int storeOcc(int[] arr, int i, int n, int key, int[] out, int j) {
		if (arr == null || out == null) {
			return 0;
		}
		if (i == n) {
			return j;
		}
		if (arr[i] == key) {
			out[j] = i;
			return storeOcc(arr, i + 1, n, key, out, j + 1);
		}
		return storeOcc(arr, i + 1, n, key, out, j);
	}

	public static void main(String[] args) {
		int[] arr = {4, 2, 7, 2, 9, 2, 5};
		int key = 2;
		int[] out = new int[arr.length];
		int totalOcc = storeOcc(arr, 0, arr.length, key, out, 0);

		System.out.println("Linear Search: " + linearSearch(arr, key, 0));
		System.out.println("First Occurrence: " + firstOcc(arr, 0, key));
		System.out.println("Last Occurrence: " + lastOcc(arr, 0, key));
		System.out.println("Second Occurrence: " + secondOcc(arr, key));
		System.out.println("Second Last Occurrence: " + secondLastOcc(arr, key));
		System.out.print("All Occurrence Indexes: ");
		for (int k = 0; k < totalOcc; k++) {
			System.out.print(out[k] + (k + 1 < totalOcc ? " " : ""));
		}
		System.out.println();
	}
}
