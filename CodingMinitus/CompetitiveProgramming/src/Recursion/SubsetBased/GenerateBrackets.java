package Recursion.SubsetBased;

import java.util.ArrayList;
import java.util.List;

/*
	Question:
	Given an integer n, generate and print all combinations of n pairs of balanced parentheses.

	Example:
	Input: n = 3
	Output:
	((()))
	(()())
	(())()
	()(())
	()()()
*/

public class GenerateBrackets {
	
	static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] current = new char[2 * n];
        
        backtrack(result, current, 0, 0, 0, n);
        return result;
    }
    
    static void backtrack(List<String> result, char[] current, int idx, int open, int close, int n) {
        
        if (idx == 2 * n) {
            result.add(new String(current));
            return;
        }
        
        if (open < n) {
            current[idx] = '(';
            backtrack(result, current, idx + 1, open + 1, close, n);
        }
        
        if (close < open) {
            current[idx] = ')';
            backtrack(result, current, idx + 1, open, close + 1, n);
        }
    }

	public static void main(String[] args) {
		int n = 3;
        List<String> ans = generateParenthesis(n);
        for (String s : ans) {
            System.out.println(s);
        }
	}
}
