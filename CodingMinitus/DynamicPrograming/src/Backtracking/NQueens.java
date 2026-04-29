/*
 * QUESTION: N-Queens Problem
 * The N-Queens is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * A queen can attack any piece that is on the same row, column, or diagonal.
 */
package Backtracking;

import java.util.Arrays;

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