package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
 * PROBLEM STATEMENT:
 * ==================
 * SET ENTIRE ROW AND COLUMN TO 0 if a cell contains 0.
 * Modify matrix in-place or use optimized space approach.
 * 
 * EXPLANATION:
 * NAIVE: Use O(m+n) extra space for row/col markers
 * OPTIMAL: Use first row/column as markers + O(1) extra space
 * 
 * ALGORITHM:
 * 1. Check if first row/col need zeroing
 * 2. Use first row/col as markers
 * 3. Traverse and zero marked cells
 * 4. Handle first row/col separately
 * 
 * EXAMPLE:
 * Input: [[1,1,1],     Output: [[1,0,1],
 *         [1,0,1],     ->      [0,0,0],
 *         [1,1,1]]            [1,0,1]]
 * 
 * TIME: O(m*n), SPACE: O(1)
 */
public class MakeZeros {
    // Brute Force
    // Time: O(n * m * (n + m))
    // Space: O(1)
    static void setZeroesBruteforce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i, m);
                    markCol(matrix, j, n);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void markRow(int[][] matrix, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    static void markCol(int[][] matrix, int j, int n) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    // Better
    // Time: O(n * m)
    // Space: O(n + m)
    static void setZeroesBetter(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal
    // Time: O(n * m)
    // Space: O(1)
    static void setZeroesOptimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = 0;

            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // My Idea
    // Time: O(n * m + z * (n + m)), where z = number of zeroes
    // Worst-case Time: O(n * m * (n + m))
    // Space: O(z)
    static void setZeroes(int[][] matrix) {
        Set<int[]> set = new HashSet<>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    set.add(new int[]{i, j});
                }
            }
        }

        for(int []i : set){
            makeZeroes(i[0],i[1],matrix);
        }
    }
    static void makeZeroes(int i,int j,int m[][]){
        for(int k = 0;k < m[0].length;k++){
            m[i][k] = 0;
        }
        for(int k = 0;k < m.length;k++){
            m[k][j] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] brute = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int[][] better = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int[][] optimal = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

    
        setZeroesBruteforce(brute);
        setZeroesBetter(better);
        setZeroesOptimal(optimal);

        System.out.println("Brute Force Output:");
        printMatrix(brute);

        System.out.println("Better Output:");
        printMatrix(better);

        System.out.println("Optimal Output:");
        printMatrix(optimal);
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
