package Recursion.Backtracking;

    /*
	 * PERMUTATIONS OF A STRING (Backtracking)
	 *
	 * Original Question:
	 * Given a string, print all possible permutations of its characters.
	 *
	 * Example:
	 * Input: "ABC"
	 * Output: ABC ACB BAC BCA CBA CAB
	 *
	 * Approach:
	 * - Fix one character at the current index.
	 * - Recursively permute the remaining substring.
	 * - Backtrack by swapping back to restore original state.
	 *
	 * Time Complexity: O(n * n!)
	 * Space Complexity: O(n) recursion stack
	 */

public class Permutations {

	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void permute(char[] input, int i) {
		if (i == input.length) {
			System.out.print(new String(input) + " ");
			return;
		}

		for (int j = i; j < input.length; j++) {
			swap(input, i, j);
			permute(input, i + 1);
			swap(input, i, j);
		}
	}

	public static void main(String[] args) {
		String str = "ABC";
		System.out.println("Input: " + str);
		System.out.print("Permutations: ");
		permute(str.toCharArray(), 0);
		System.out.println();
	}
}
