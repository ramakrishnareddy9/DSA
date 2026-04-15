package NumberTheory.PrimesAndFactorization;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// optimizing memory

public class BitSetSieve {

    static final int N = 10_000_000;

    static BitSet bitSet = new BitSet(N + 1);
    static List<Integer> primes = new ArrayList<>();

    static void sieve() {
        bitSet.set(0, N + 1);

        bitSet.clear(0);
        bitSet.clear(1);

        for (int i = 2; i <= N; i++) {
            if (bitSet.get(i)) {
                primes.add(i);

                for (long j = (long) i * i; j <= N; j += i) {
                    bitSet.clear((int) j);
                }
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        System.out.println("Total primes: " + primes.size());
        System.out.println("First 10 primes: " + primes.subList(0, 10));
    }
}
