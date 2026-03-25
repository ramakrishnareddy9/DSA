package Recursion.Basic;

public class StringToNumber {
    static int stringToInt(char[] a, int n) {
        if (n == 0) {
            return 0;
        }

        int digit = a[n - 1] - '0';
        int smallAns = stringToInt(a, n - 1);

        return smallAns * 10 + digit;
    }

    static int stringToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return stringToInt(s.toCharArray(), s.length());
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("204"));
        System.out.println(stringToInt("5"));
        System.out.println(stringToInt(""));
    }
}
