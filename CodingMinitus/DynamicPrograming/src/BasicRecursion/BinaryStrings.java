/*
 * QUESTION: Binary Strings
 * Count the number of binary strings with no consecutive ones that can be formed using a binary string of Length N.
 * Input: N
 * Output: Count of Strings
 */
package BasicRecursion;

public class BinaryStrings {
    static int countStrings(int n, int prev) {
        if (n == 0) {
            return 1;
        }
        if (prev == 1) {
            return countStrings(n - 1, 0);
        }
        return countStrings(n - 1, 0) + countStrings(n - 1, 1);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countStrings(n, 0));
    }
}
