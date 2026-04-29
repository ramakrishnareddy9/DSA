package DynammicProgrammingOneDimensional;

public class Factorial {

    public static int factorialRecursive(int n) {
        if (n == 0)
            return 1; // Base case: 0! = 1
        return n * factorialRecursive(n - 1); // Recursive case
    }

    public static int factorialTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: 0! = 1

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * i;
        }

        return dp[n];
    }

    public static int factorialMemoization(int n, int[] dp) {
        if (n == 0)
            return 1;
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = n * factorialMemoization(n - 1, dp);
        return dp[n];
    }

    public static int factorial(int n) { // most optimal way
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial (Recursive): " + factorialRecursive(n));
        System.out.println("Factorial (Tabulation): " + factorialTabulation(n));
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println("Factorial (Memoization): " + factorialMemoization(n, dp));
        System.out.println(factorial(n));
    }
}
