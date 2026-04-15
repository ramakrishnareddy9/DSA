package Recursion.SubsetBased;

import java.util.*;

/*
 * PHONE KEYPAD PROBLEM
 * 
 * Problem Statement:
 * Given a string containing digits from 2-9, return all possible letter combinations 
 * that the number could represent on a phone keypad (like old T9 texting).
 * 
 * Keypad Mapping:
 * 2 = "ABC"
 * 3 = "DEF"
 * 4 = "GHI"
 * 5 = "JKL"
 * 6 = "MNO"
 * 7 = "PQRS"
 * 8 = "TUV"
 * 9 = "WXYZ"
 * Note: 0 and 1 have no letters mapped to them.
 * 
 * Example 1:
 * Input: "23"
 * Output: ["AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"]
 * Explanation: 2 maps to "ABC", 3 maps to "DEF" -> combinations are A+D, A+E, A+F, B+D, etc.
 * 
 * Example 2:
 * Input: ""
 * Output: []
 * 
 * Example 3:
 * Input: "2"
 * Output: ["A", "B", "C"]
 * 
 * Approach: Use Recursion (Subset-based/Backtracking)
 * - For each digit, append all possible letters to the current string
 * - Recursively process the next digit
 * - When all digits are processed, add the result to the list
 * 
 * Time Complexity: O(4^n) where n is the number of digits (9 has 4 letters max)
 * Space Complexity: O(4^n) for storing results in the list
 */

public class PhoneKeypadProblem {
    // Alternate GFG-style approach 
    /*
    String[] keypad = {
        "", "", "abc", "def", "ghi","jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        
        if (arr.length == 0) return result;
        
        generate(arr, 0, new StringBuilder(), result);
        return result;
    }
    
    void generate(int[] arr, int index, StringBuilder current, ArrayList<String> result) {
        
        if (index == arr.length) {
            if (current.length() > 0) {
                result.add(current.toString());
            }
            return;
        }
        
        if (arr[index] == 0 || arr[index] == 1) {
            generate(arr, index + 1, current, result);
            return;
        }
        
        String letters = keypad[arr[index]];
        
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            generate(arr, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    */
    
    static String[] keypad = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    
    public static void generateCombinations(String digits, int index, String current, List<String> result) {
        if (index == digits.length()) {
            if (current.length() > 0) {
                result.add(current);
            }
            return;
        }
        
        String letters = keypad[digits.charAt(index) - '0'];
    
        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, index + 1, current + letters.charAt(i), result);
        }
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        generateCombinations(digits, 0, "", result);
        return result;
    }
    
    public static void main(String[] args) {
        String input = "23";
        List<String> combinations = letterCombinations(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + combinations);
    }
}