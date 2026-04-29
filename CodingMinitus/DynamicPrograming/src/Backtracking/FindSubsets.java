/*
 * QUESTION: Finding Subsets
 * Given a string, find all subsets of the given string.
 * Input: abc
 * Output: "", a, b, c, ab, ac, bc, abc
 */
package Backtracking;

public class FindSubsets {
    public static void findSubsets(String input, int i, String output) {
        if (i == input.length()) {
            System.out.println(output.isEmpty() ? "NULL" : output);
            return;
        }
        findSubsets(input, i + 1, output + input.charAt(i));
        findSubsets(input, i + 1, output);
    }

    public static void main(String[] args) {
        String input = "abc";
        findSubsets(input, 0, "");
    }
}
