public class FibonacciAllMethods {

    // =========================================================
    // 1. SIMPLE RECURSION
    // =========================================================
    /*
     * Method Name: fibonacciRecursive
     *
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) (recursion stack)
     *
     * Use Case:
     * - Educational / concept understanding
     * - Not suitable beyond n > 40 (very slow)
     */

    static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


    // =========================================================
    // 2. ITERATIVE (LOOP)
    // =========================================================
    /*
     * Method Name: fibonacciIterative
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Use Case:
     * - Efficient for moderate n (up to ~10^7)
     * - Best general-purpose solution (simple + fast)
     */

    static long fibonacciIterative(int n) {
        if (n <= 1) return n;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


    // =========================================================
    // 3. MATRIX EXPONENTIATION
    // =========================================================
    /*
     * Method Name: fibonacciMatrix
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     *
     * Use Case:
     * - Large n (up to 10^18 with modulo)
     * - Used in CP, backend systems, cryptography
     * - Exact and scalable
     */

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];

        result[0][0] = A[0][0]*B[0][0] + A[0][1]*B[1][0];
        result[0][1] = A[0][0]*B[0][1] + A[0][1]*B[1][1];
        result[1][0] = A[1][0]*B[0][0] + A[1][1]*B[1][0];
        result[1][1] = A[1][0]*B[0][1] + A[1][1]*B[1][1];

        return result;
    }

    static long[][] power(long[][] matrix, long n) {
        if (n == 1) return matrix;

        if (n % 2 == 0) {
            long[][] half = power(matrix, n / 2);
            return multiply(half, half);
        } else {
            return multiply(matrix, power(matrix, n - 1));
        }
    }

    static long fibonacciMatrix(long n) {
        if (n == 0) return 0;

        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = power(base, n - 1);

        return result[0][0];
    }


    // =========================================================
    // 4. BINET’S FORMULA
    // =========================================================
    /*
     * Method Name: fibonacciBinet
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * Use Case:
     * - Small n (<= 70)
     * - Mathematical / theoretical usage
     * - Not reliable for large n (precision loss)
     */

    static long fibonacciBinet(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;

        return Math.round((Math.pow(phi, n) - Math.pow(psi, n)) / sqrt5);
    }

    public static void main(String[] args) {

        int n = 10;
        System.out.println("Recursive: " + fibonacciRecursive(n));
        System.out.println("Iterative: " + fibonacciIterative(n));
        System.out.println("Matrix Exponentiation: " + fibonacciMatrix(n));
        System.out.println("Binet's Formula: " + fibonacciBinet(n));
    }
}