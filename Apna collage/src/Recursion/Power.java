package Recursion;

import java.util.Scanner;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Compute x raised to the power n (x^n) using recursion and optimized approaches.
 * 
 * EXPLANATION:
 * Two approaches:
 * 1. Naive Recursion: x^n = x * x^(n-1) - Time: O(n)
 * 2. Optimized (Divide & Conquer): Uses x^(n/2) - Time: O(log n)
 *    - If n is even: x^n = (x^(n/2))^2
 *    - If n is odd: x^n = x * x^(n-1)
 * 
 * EXAMPLES:
 * Input: x = 2, n = 5
 * Output: 32 (2^5 = 2*2*2*2*2)
 * 
 * Input: x = 3, n = 4
 * Output: 81 (3^4 = 81)
 * 
 * EDGE CASES:
 * - n = 0: Result is 1 (any number^0 = 1)
 * - Negative exponents possible
 * 
 * CONSTRAINTS:
 * - Base can be any number (integer or double)
 * - Exponent can be negative
 * 
 * TIME COMPLEXITY: O(log n) for optimized
 * SPACE COMPLEXITY: O(log n) for recursion stack
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
