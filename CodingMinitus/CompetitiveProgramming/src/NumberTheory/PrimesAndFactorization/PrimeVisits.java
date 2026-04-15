package NumberTheory.PrimesAndFactorization;

import java.util.Arrays;

public class PrimeVisits {

    static int[] sieveWithPrefix(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1];
            if (isPrime[i]) {
                prefix[i]++;
            }
        }
        return prefix;
    }

    static int noOfPrimeNumberInRange(int a, int b) {
        int[] prefix = sieveWithPrefix(b);
        
        if (a == 0) return prefix[b];
        return prefix[b] - prefix[a - 1];
    }

    public static void main(String[] args) {
        int a = 10, b = 30;
        System.out.println(noOfPrimeNumberInRange(a, b)); // Output: 6 (11,13,17,19,23,29)
    }
}