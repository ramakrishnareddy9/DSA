/*
 * QUESTION: Generating Brackets
 * Write a function to generate all possible n pairs of balanced parentheses '(' and ')'.
 * Input: 2
 * Output: ( ) ( ), ( ( ) )
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratatingBrackets {
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    static void backtrack(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> combinations = generateParenthesis(n);
        System.out.println("Valid Parentheses Combinations for n = " + n + ":");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}
