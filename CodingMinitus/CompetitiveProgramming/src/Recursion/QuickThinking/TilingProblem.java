package Recursion.QuickThinking;

/*
Given a wall of size of 4 * n, and tiles of size (1,4) and (4,1). In how many ways can you build a wall
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
