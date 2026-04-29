/*
 * QUESTION: Tiling Problem
 * Given a "4 x n" board and tiles of size "4 x 1", count the number of ways to tile the given board using the 4 x 1 tiles.
 * A tile can either be placed horizontally i.e., as a 1 x 4 tile or vertically i.e., as 4 x 1 tile.
 * Input: N
 * Output: No of ways
 */
package BasicRecursion;

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
