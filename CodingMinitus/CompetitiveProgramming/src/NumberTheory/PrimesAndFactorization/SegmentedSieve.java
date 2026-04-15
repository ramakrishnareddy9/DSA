package NumberTheory.PrimesAndFactorization;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Problem: Generate Primes in a Range

Peter is building a cryptosystem and needs prime numbers. Your task is to generate all prime numbers between two given numbers.
Input:
    First line contains an integer t → number of test cases
    (1 ≤ t ≤ 10)
    Next t lines each contain two integers:
    m and n
Constraints:
    1 ≤ m ≤ n ≤ 1,000,000,000
    n - m ≤ 100,000
Output:
    For each test case:
        Print all prime numbers p such that:
            m ≤ p ≤ n
            Print one prime per line
            Add an empty line between test cases
Example
    Input
        2
        1 10
        3 5
    Output
        2
        3
        5
        7

        3
        5
*/

public class SegmentedSieve {
    // Generate primes up to sqrt(n)
    static List<Integer> generateBasePrimes(int limit) {
        boolean[] isComposite = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i * i <= limit; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Segmented sieve for range [m, n]
    private static List<Integer> segmentedSieve(int m, int n) {
        int limit = (int) Math.sqrt(n);
        List<Integer> basePrimes = generateBasePrimes(limit);

        boolean[] isComposite = new boolean[n - m + 1];

        for (int prime : basePrimes) {

            // Find first multiple of prime in range [m, n]
            int start = Math.max(prime * prime, ((m + prime - 1) / prime) * prime);

            for (int j = start; j <= n; j += prime) {
                isComposite[j - m] = true;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            if (i > 1 && !isComposite[i - m]) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        while (t-- > 0) {
            int m = s.nextInt();
            int n = s.nextInt();

            List<Integer> primes = segmentedSieve(m, n);

            for (int p : primes) {
                System.out.println(p);
            }
            System.out.println();
        }

        s.close();
    }
}
