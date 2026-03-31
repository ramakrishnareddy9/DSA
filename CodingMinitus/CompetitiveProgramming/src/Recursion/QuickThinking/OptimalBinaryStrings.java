package Recursion.QuickThinking;

/*
 * PROBLEM STATEMENT:
 * Count binary strings of length n where NO TWO CONSECUTIVE BITS are 1.
 * OR: Generate all such valid binary strings.
 * 
 * EXPLANATION:
 * For a string to be valid:
 * - Can start with 0 or 1
 * - After 1, must have 0
 * - After 0, can have 0 or 1
 * 
 * Recurrence Relation: f(n) = f(n-1, last=0) + f(n-1, last=1)
 * Where:
 * - f(n, last=0): strings ending in 0
 * - f(n, last=1): strings ending in 1
 * 
 * Also follows: f(n) = fib(n+2) pattern
 * 
 * EXAMPLES:
 * n=1: "0", "1" (count=2)
 * n=2: "00", "01", "10" (count=3, "11" excluded)
 * n=3: "000", "001", "010", "100", "101" (count=5)
 * 
 * TIME COMPLEXITY: O(2^n)
 * SPACE COMPLEXITY: O(n)
 */
public class OptimalBinaryStrings {
    static int countStrings(int n, int prev) {
        if (n == 0) {
            return 1;
        }
        if (prev == 1) {
            return countStrings(n - 1, 0);
        }
        return countStrings(n - 1, 0) + countStrings(n - 1, 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countStrings(n, 0));
    }
}
