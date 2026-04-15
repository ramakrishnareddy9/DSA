package NumberTheory.PrimesAndFactorization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {
    static boolean isPrime(int n){
        if(n == 1) return true;
        if(n == 2) return true;
        for(int i = 0;i * i < n;i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    // TimeComplexity : O(N * log log N)
    static List<Integer> sieveApproach(int n){
        List<Integer> primes = new ArrayList<>();
        if (n <= 2) return primes;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
