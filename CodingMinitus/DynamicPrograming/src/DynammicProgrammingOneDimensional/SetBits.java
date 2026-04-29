package DynammicProgrammingOneDimensional;

import java.util.Arrays;

// print no of set bits from 1 to n ?
// decimal->binary->no of ones
// ex:1->1->1
// 2->10->1
// 3->11->2
// 4->100->1
// 5->101->2
// 6->110->2
// 7->111->3
// 8->1000->1
// 9->1001->2
// 10->1010->2

public class SetBits {
    static int bruteForce(int n) { // time complexity is log(n) for the function and n for loop in main function so
                                   // its O(n log(n))
        int count = 0;
        while (n > 0) {
            count += n % 2;
            n /= 2;
        }
        return count;
    }

    static int[] optimalUsingDP(int n) { // time complexity is O(n)
        int DP[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            DP[i] = DP[i / 2] + (i % 2);
        }
        return DP;
    }

    public static void main(String[] args) {
        int n = 10;
        for (int i = 1; i <= n; i++) {
            System.out.print(bruteForce(i) + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(optimalUsingDP(n)));
    }
}
