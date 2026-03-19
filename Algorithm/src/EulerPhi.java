// Euler's Phi Function:

// Euler's Phi Function, denoted as φ(n), counts the number of positive integers up to n that are relatively prime to n. Two numbers are considered relatively prime (or coprime) if their greatest common divisor (GCD) is 1.
// Key points about Euler's Phi Function:

// For a prime number p, φ(p) = p - 1, as all positive integers less than p are coprime to it.
// It's a multiplicative function, meaning if a and b are coprime, then φ(ab) = φ(a) * φ(b).
// For a prime power p^k, φ(p^k) = p^k - p^(k-1) = p^k * (1 - 1/p).
// For any positive integer n:
// n = p1^a1 * p2^a2 * ... * pk^ak (prime factorization)
// φ(n) = n * (1 - 1/p1) * (1 - 1/p2) * ... * (1 - 1/pk)

// Algorithm to calculate Euler's Phi Function:

// Initialize result as n.
// Consider all prime factors of n and for every prime factor p, multiply result with (1 - 1/p).
// Return the result.

public class EulerPhi {
    
    public static int phi(int n) {
        int result = n;
        
        
        for (int p = 2; p * p <= n; ++p) {
            
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        
        
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] testNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 100};
        
        for (int n : testNumbers) {
            System.out.println("φ(" + n + ") = " + phi(n));
        }
    }
}

