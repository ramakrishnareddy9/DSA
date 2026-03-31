package Recursion;

import java.util.Scanner;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Generate all binary strings of length n such that no two consecutive bits are 1.
 * 
 * EXPLANATION:
 * This problem requires generating all valid binary strings where no two adjacent digits are both 1.
 * For example, "101", "010" are valid, but "110", "111" are invalid.
 * 
 * EXAMPLES:
 * Input: n = 2
 * Output: 00, 01, 10
 * (11 is excluded because two consecutive 1s are not allowed)
 * 
 * Input: n = 3
 * Output: 000, 001, 010, 100, 101
 * 
 * CONSTRAINTS:
 * - 1 <= n <= 20
 * - Use recursion with backtracking
 * - lastDigit tracks the previous digit to prevent consecutive 1s
 * 
 * TIME COMPLEXITY: O(2^n)
 * SPACE COMPLEXITY: O(n) for recursion stack
 */
public class BinaryStrings {

    static void binaryStrings(int n,int lastDigit,String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        binaryStrings(n - 1,lastDigit,str + "1");
        if(lastDigit == 0){
            binaryStrings(n,1,str + "0");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        binaryStrings(n,0,"");
        s.close();
    }
}
