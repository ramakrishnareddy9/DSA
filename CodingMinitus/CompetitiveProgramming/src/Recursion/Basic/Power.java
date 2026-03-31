package Recursion.Basic;

import java.util.Scanner;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Compute x raised to the power n (x^n) using recursion.
 * Implement both naive and optimized divide-and-conquer approaches.
 * 
 * EXPLANATION:
 * NAIVE: x^n = x * x^(n-1)  [Time: O(n)]
 * OPTIMIZED: x^n = (x^(n/2))^2 if even, x * x^(n-1) if odd  [Time: O(log n)]
 * 
 * EXAMPLES:
 * Input: x = 2, n = 5
 * Output: 32.0
 * 
 * Input: x = 3, n = 4
 * Output: 81.0
 * 
 * EDGE CASES:
 * - n = 0 -> Result = 1
 * - Negative exponents
 * - Negative base
 * 
 * TIME COMPLEXITY: O(log n) for optimized, O(n) for naive
 * SPACE COMPLEXITY: O(log n) recursive stack
 */
public class Power {
    // O(n)
    static double power(double base, int exp){
        if(exp == 0){
            return 1;
        }
        if(exp < 0){
            return 1 / power(base, -exp);
        }
        return base * power(base, exp - 1);
    }
    // O(log n)
    static double powerOptimized(double base, int exp){
        if(exp == 0){
            return 1;
        }
        if(exp < 0){
            return 1 / powerOptimized(base, -exp);
        }
        double half = powerOptimized(base, exp / 2);
        if(exp % 2 == 0){
            return half * half;
        } else {
            return base * half * half;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double base = s.nextDouble();
        int exp = s.nextInt();

        System.out.println(power(base, exp));
        System.out.println(powerOptimized(base, exp));

        s.close();
    }
}
