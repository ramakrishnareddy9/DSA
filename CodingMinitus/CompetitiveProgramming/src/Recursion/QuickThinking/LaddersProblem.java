package Recursion.QuickThinking;

/*
 * Question:
 * Count ways to reach the nth step when up to k jumps are allowed at each move.
 */
public class LaddersProblem {
    // n = staircase k = number stemps can take 1 to k
	static int ladder(int n, int k) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}

		int ans = 0;
		for (int i = 1; i <= k; i++) {
			ans += ladder(n - i, k);
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 4;
		int k = 3;
		System.out.println(ladder(n, k));
	}
}
