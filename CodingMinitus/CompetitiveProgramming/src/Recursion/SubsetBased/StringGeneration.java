package Recursion.SubsetBased;

/*
 * STRING GENERATION FROM NUMBERS
 * 
 * Problem Statement:
 * Given a string containing digits, generate all possible strings where:
 * - Single digit can be converted to a letter (1='A', 2='B', ..., 26='Z')
 * - Two consecutive digits can form a number (10-26) that maps to a letter
 * - For example: "12" can be decoded as:
 *   1. '1' and '2' -> 'A' and 'B' -> "AB"
 *   2. '12' (as a single number) -> 'L' -> "L"
 * 
 * Example 1:
 * Input: "12"
 * Output: ["AB", "L"]
 * Explanation: 1 maps to 'A', 2 maps to 'B', OR 12 maps to 'L'
 * 
 * Example 2:
 * Input: "226"
 * Output: ["BBF", "BZ", "VF"]
 * Explanation:
 * - 2,2,6 -> 'B','B','F' -> "BBF"
 * - 2,26 -> 'B','Z' -> "BZ"
 * - 22,6 -> 'V','F' -> "VF"
 * 
 * Example 3:
 * Input: "06"
 * Output: [] (invalid - 0 cannot be decoded alone, 06 is invalid)
 * 
 * Example 4:
 * Input: "109"
 * Output: ["JI"]
 * Explanation: 
 * - Cannot use '1','0','9' because 0 alone is invalid
 * - Can use '10','9' -> 'J','I' -> "JI"
 * - Cannot use '1','09' because 09 is invalid (two-digit > 26)
 * 
 * Approach: Use Recursion (Subset-based/Backtracking)
 * - Try decoding one digit at a time
 * - Try decoding two digits at a time (if they form a valid number 10-26)
 * - Stop when all digits are processed
 * 
 * Time Complexity: O(2^n) where n is the length of the input string
 * Space Complexity: O(n) for recursion depth
 */

public class StringGeneration {

    public static void generateStrings(String input, int i, String output) {
        if (i == input.length()) {
            System.out.println(output);
            return;
        }

        if (input.charAt(i) == '0') {
            return;
        }

        int digit = input.charAt(i) - '0';
        char ch1 = (char) (digit + 'A' - 1);
        generateStrings(input, i + 1, output + ch1);

        if (i + 1 < input.length()) {
            int number = Integer.parseInt(input.substring(i, i + 2));
            if (number >= 10 && number <= 26) {
                char ch2 = (char) (number + 'A' - 1);
                generateStrings(input, i + 2, output + ch2);
            }
        }
    }

    public static void main(String[] args) {
        String input = "102";
        System.out.println("Input: " + input);
        System.out.println("Output:");
        generateStrings(input, 0, "");
    }
}