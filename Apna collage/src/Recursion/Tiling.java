package Recursion;

import java.util.Scanner;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Count the number of ways to tile a 2 x n board using 2 x 1 tiles.
 * Each tile can be placed either horizontally or vertically.
 * 
 * EXPLANATION:
 * For a 2xn board, at the leftmost position we can:
 * 1. Place a vertical tile (covers 1 column) -> leaves 2x(n-1) board
 * 2. Place two horizontal tiles (covers 2 columns) -> leaves 2x(n-2) board
 * 
 * Recurrence: f(n) = f(n-1) + f(n-2) [This is Fibonacci!]
 * 
 * EXAMPLES:
 * n = 1: 1 way (one vertical tile)
 * n = 2: 2 ways
 *   - Place vertically: ||
 *   - Place horizontally: -- --
 * n = 3: 3 ways
 * n = 4: 5 ways
 * 
 * VISUALIZATION:
 * 2x1: 1 (|)
 * 2x2: 2 (|| or ==)
 * 2x3: 3
 * 
 * CONSTRAINTS:
 * - 1 <= n <= 20
 * - This follows Fibonacci sequence: 1, 2, 3, 5, 8, 13...
 * 
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 */
public class Tiling {
    static int tiling(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int vertical = tiling(n - 1);
        int horizontal = tiling(n - 2);

        return vertical + horizontal;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(tiling(n));
        s.close();
    }
}
