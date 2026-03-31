package Recursion;

import java.util.Scanner;

/*
 * PROBLEM STATEMENT:
 * ==================
 * Count the number of ways n friends can remain single or be paired up.
 * Each friend can either stay alone or be paired with exactly one other friend.
 * 
 * EXPLANATION:
 * For n friends, each friend has multiple choices:
 * 1. Stay single (then solve for n-1 friends)
 * 2. Pair with any of the remaining (n-1) friends (then solve for n-2 friends)
 * 
 * Recurrence Relation: f(n) = f(n-1) + (n-1) * f(n-2)
 * - f(n-1): nth friend stays single
 * - (n-1) * f(n-2): nth friend pairs with one of (n-1) choices
 * 
 * EXAMPLES:
 * n = 1: Only 1 way (friend alone) = 1
 * n = 2: 2 ways (both alone OR paired) = 2
 * n = 3: 4 ways
 *   - All alone: AAA
 *   - Pair (0,1): PA|A
 *   - Pair (0,2): A|PA
 *   - Pair (1,2): A|PA
 * n = 4: 10 ways
 * 
 * CONSTRAINTS:
 * - 1 <= n <= 20
 * - Result can be large (use long type)
 * 
 * TIME COMPLEXITY: O(n)
 * SPACE COMPLEXITY: O(n)
 */
public class FriendsParing {

    static int friendsParing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        int single = friendsParing(n - 1);
        int pair = friendsParing(n - 2) * (n - 1);

        return single + pair;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(friendsParing(n));
        s.close();
    }
}
