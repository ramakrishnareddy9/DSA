package Recursion.Basic;

public class PrintNumberRecursion {
    static String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    static void printSpellings(int n) {
        if (n == 0) {
            return;
        }

        printSpellings(n / 10);
        int digit = n % 10;
        System.out.print(words[digit] + " ");
    }

    public static void main(String[] args) {
        printSpellings(204);
        System.out.println();
        printSpellings(12345);
        System.out.println();
        printSpellings(987654);
    }
}
