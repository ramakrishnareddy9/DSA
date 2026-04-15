package NumberTheory.PrimesAndFactorization;

import java.util.ArrayList;
import java.util.List;

public class LargePrimeCheckusingsieve {

    static final int LIMIT = 1000000; // sqrt(10^12)
    static List<Integer> primes = new ArrayList<>();

    static void sieve() {
        boolean[] isPrime = new boolean[LIMIT + 1];

        for (int i = 2; i <= LIMIT; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= LIMIT; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    static boolean isPrime(long n) {
        if (n < 2) return false;

        for (int prime : primes) {
            if ((long) prime * prime > n) break;
            if (n % prime == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        sieve();
        long num = 9999999967L;
        System.out.println(isPrime(num));
    }
}