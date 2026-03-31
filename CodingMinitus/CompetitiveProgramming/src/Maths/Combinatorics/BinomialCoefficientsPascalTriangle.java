package Maths.Combinatorics;

/*
 * Question:
 * Compute binomial coefficient C(n, k) using Pascal triangle / combinatorics methods.
 */
public class BinomialCoefficientsPascalTriangle {
    
    // Calculate C(n, k) using Pascal's Triangle formula
    public static long binomialCoefficient(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        
        return result;
    }
    
    // Build Pascal's Triangle up to n rows
    public static int[][] pascalTriangle(int n) {
        int[][] triangle = new int[n][];
        
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        
        return triangle;
    }
    
    public static void main(String[] args) {
        System.out.println("C(5, 2) = " + binomialCoefficient(5, 2));
        System.out.println("C(6, 3) = " + binomialCoefficient(6, 3));
    }
}
