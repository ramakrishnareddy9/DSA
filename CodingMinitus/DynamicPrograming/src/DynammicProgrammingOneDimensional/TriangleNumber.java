package DynammicProgrammingOneDimensional;

// Question : N th triangle number

public class TriangleNumber {

    public static int triangleRecursive(int n) {
        if (n == 0)
            return 0;
        return n + triangleRecursive(n - 1);
    }

    public static int triangleTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + i;
        }
        return dp[n];
    }

    public static int triangleMemoization(int n, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = n + triangleMemoization(n - 1, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Triangle Number (Recursive): " + triangleRecursive(n));
        System.out.println("Triangle Number (Tabulation): " + triangleTabulation(n));
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println("Triangle Number (Memoization): " + triangleMemoization(n, dp));
    }
}
