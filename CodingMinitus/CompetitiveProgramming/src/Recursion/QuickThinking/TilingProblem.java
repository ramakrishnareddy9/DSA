package Recursion.QuickThinking;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Count ways to tile a 4 x n wall using tiles of size 4x1 and 1x4.
 * You can place tiles either horizontally or vertically.
 * 
 * EXPLANATION:
 * For a 4xn wall, at the leftmost position:
 * 1. Place 1 vertical tile (4x1) -> leaves 4x(n-1)
 * 2. Place 4 horizontal tiles (4 × 1x4) -> leaves 4x(n-4)
 * 
 * Recurrence: f(n) = f(n-1) + f(n-4)
 * 
 * BASE CASES:
 * f(0) = 1 (empty wall)
 * f(1) = 1 (1 vertical tile)
 * f(2) = 1 (2 vertical tiles)
 * f(3) = 1 (3 vertical tiles)
 * f(4) = 2 (4 vertical OR 4 horizontal)
 * 
 * EXAMPLES:
 * n=1: 1 way
 * n=2: 1 way
 * n=3: 1 way
 * n=4: 2 ways
 * n=5: 3 ways
 * 
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 */
public class TilingProblem {
    static int tiling(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        return tiling(n - 1) + tiling(n - 4);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Total no of waysv: " + tiling(n));
    }
}
