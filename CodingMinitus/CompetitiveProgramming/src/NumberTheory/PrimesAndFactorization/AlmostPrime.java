package NumberTheory.PrimesAndFactorization;

/*
A number is called almost prime if it has exactly two distinct prime divisors.
Examples
    Almost Prime:
        6 → (2 × 3)
        18 → (2 × 3²)
        24 → (2³ × 3)
    Not Almost Prime:
        4 → (2² → only 1 distinct prime)
        8 → (2³ → only 1 distinct prime)
        9 → (3² → only 1 distinct prime)
        42 → (2 × 3 × 7 → 3 distinct primes)
Task:
    Given an integer n, find the count of almost prime numbers between 1 and n (inclusive).
Input:
    A single integer: 1 ≤ n ≤ 3000
Output:
    Print a single integer: Number of almost prime numbers between 1 and n
*/

public class AlmostPrime {
    
    static int sieve(int n) {
        int primes[] = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) { 
                for (int j = i; j <= n; j += i) {
                    primes[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 2) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 30;
        System.out.println(sieve(n));
    }
}