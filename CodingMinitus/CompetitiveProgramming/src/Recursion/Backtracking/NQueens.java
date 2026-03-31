package Recursion.Backtracking;

import java.util.Arrays;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Place N QUEENS on an NxN chessboard such that:
 * - No two queens can be on the same ROW
 * - No two queens can be on the same COLUMN
 * - No two queens can be on the same DIAGONAL (both ways)
 * 
 * EXPLANATION:
 * Use BACKTRACKING:
 * 1. Try placing queen in each row
 * 2. For each column, check if it's safe (not attacked by other queens)
 * 3. If safe, place queen and move to next row
 * 4. If not safe, backtrack and try next column
 * 
 * SAFETY CHECK:
 * - Same column: Check colPlaced array
 * - Upper diagonal: Check (row - col) constant
 * - Lower diagonal: Check (row + col) constant
 * 
 * EXAMPLES:
 * N=1: 1 solution
 * N=2: 0 solutions
 * N=3: 0 solutions
 * N=4: 2 solutions
 * N=8: 92 solutions (8-queens problem)
 * 
 * TIME COMPLEXITY: O(N!)
 * SPACE COMPLEXITY: O(N) - recursion stack
 */
public class NQueens {
    static int count = 0;

    static boolean canPlace(int[][] board, int n, int x, int y) {
        for (int k = 0; k < x; k++) {
            if (board[k][y] == 1)
                return false;
        }
        int i = x, j = y;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        i = x;
        j = y;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        return true;
    }

    static boolean solveNQueen(int n, int[][] board, int i) { // for first possible way
        if (i == n) {
            printBoard(n, board);
            return true;
        }

        for (int j = 0; j < n; j++) {
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                if (solveNQueen(n, board, i + 1))
                    return true;
                board[i][j] = 0;
            }
        }
        return false;
    }

    static void solveNQueenAllPossibleWays(int n, int[][] board, int i) {
        if (i == n) {
            printBoard(n, board);
            count++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (canPlace(board, n, i, j)) {
                board[i][j] = 1;
                solveNQueenAllPossibleWays(n, board, i + 1);
                board[i][j] = 0;
            }
        }
    }

    static void printBoard(int n, int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], 0);
        solveNQueenAllPossibleWays(n, board, 0);
        System.out.println("total ways we can arrange " + count);
    }
}