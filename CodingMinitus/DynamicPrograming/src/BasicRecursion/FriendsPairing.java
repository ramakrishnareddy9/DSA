/*
 * QUESTION: Friend's Pairing Problem
 * Given n friends who want to go to party, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once.
 * Find out the total number of ways in which friends can remain single or can be paired up.
 */
package BasicRecursion;

public class FriendsPairing {
    static int pairing(int n) {
        if (n <= 2) {
            return n;
        }
        return pairing(n - 1) + (n - 1) * pairing(n - 2);
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("total no of ways to pair :" + pairing(n));
    }
}
