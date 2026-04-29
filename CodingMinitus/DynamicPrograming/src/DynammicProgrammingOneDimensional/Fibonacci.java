package DynammicProgrammingOneDimensional;

import java.util.HashMap;

public class Fibonacci {
    static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static HashMap<Integer, Integer> memo = new HashMap<>(); // using HashMap Memoization

    static int fibonacci_Memoization(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int result = fibonacci_Memoization(n - 1) + fibonacci_Memoization(n - 2);
        memo.put(n, result);
        return result;
    }

    static int[] memo1; // using array memoization

    static int fibonacci_Memoization1(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo1[n] != -1) {
            return memo1[n];
        }
        memo1[n] = fibonacci_Memoization(n - 1) + fibonacci_Memoization(n - 2);
        return memo1[n];
    }

    static int fibonacci_Tabulation(int n) {
        int fib[] = new int[n + 1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    // most optimal time complexity o(n) ,space = o(1)
    static int fibonacci(int n) {
        if (n == 0)
            return 0;
        int a = 0, b = 1;
        for (int i = 1; i < n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));
        System.out.println(fibonacci_Memoization(n));
        System.out.println(fibonacci_Tabulation(n));
    }
}
