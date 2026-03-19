// Karatsuba's Algorithm:

// Karatsuba's algorithm is a fast multiplication algorithm that was discovered by Anatolii Karatsuba in 1960. It's a divide-and-conquer algorithm that reduces the number of single-digit multiplications needed for multiplying two large numbers.
// Key points:

// It's faster than the traditional grade-school multiplication algorithm for large numbers.
// It reduces the time complexity from O(n^2) to approximately O(n^1.585), where n is the number of digits.
// It's particularly effective for multiplying very large numbers, often used in computer algebra systems and for multiplying large polynomials.

// The basic idea of Karatsuba's algorithm:
// For multiplying two n-digit numbers x and y:

// 1. Split x and y into two halves each: x = a10^(n/2) + b, y = c10^(n/2) + d
// 2. Recursively compute three products:

// 		ac = a * c
// 		bd = b * d
// 		ad_bc = (a + b) * (c + d) - ac - bd


// 3. Combine these to get the final result:
//    xy = ac10^n + ad_bc10^(n/2) + bd
   
   
public class Karatsuba {

    public static long karatsuba(long x, long y){
        // Base case: if the numbers are small enough, use standard multiplication
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Calculate the number of digits in the larger number
        int n = Math.max(String.valueOf(x).length(), String.valueOf(y).length());
        int half = n / 2;

        // Split the numbers
        long a = x / (long)Math.pow(10, half);
        long b = x % (long)Math.pow(10, half);
        long c = y / (long)Math.pow(10, half);
        long d = y % (long)Math.pow(10, half);

        // Recursive steps
        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long ad_bc = karatsuba(a + b, c + d) - ac - bd;

        // Combine the results
        return ac * (long)Math.pow(10, 2 * half) +
               ad_bc * (long)Math.pow(10, half) +
               bd;
    }

    public static void main(String[] args) 
	{
        long x = 1234;
        long y = 5678;
        
        long result = karatsuba(x, y);
        long expected = x * y;
        
        System.out.println("Karatsuba result: " + result);
        System.out.println("Expected result: " + expected);
        System.out.println("Correct: " + (result == expected));

        // Test with larger numbers
        x = 12345678;
        y = 87654321;
        
        result = karatsuba(x, y);
        expected = x * y;
        
        System.out.println("\nLarger numbers:");
        System.out.println("Karatsuba result: " + result);
        System.out.println("Expected result: " + expected);
        System.out.println("Correct: " + (result == expected));
    }
}