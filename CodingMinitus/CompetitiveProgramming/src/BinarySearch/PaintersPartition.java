package BinarySearch;

/*
Given K painters to paint N boards where each painter takes 1 unit of time to paint 1 unit of board, i.e., if the length of a particular board is 5, it will take 5 units of time to paint that board. Compute the minimum amount of time to paint all the boards.

Note that:
    Every painter can paint only contiguous segments of boards.
    A board can only be painted by 1 painter at maximum.

Input Format
    First line contains K which is the number of painters.
    Second line contains N which indicates the number of boards.
    Third line contains N space separated integers representing the length of each board.

Output Format
    Output the minimum time required to paint the board.

Constraints
    1 <= K <= 10
    1 <= N <= 10^5
    1 <= length of each board <= 10^9

Sample Input
    2
    4
    10 20 30 40
Sample Output
    60
*/

public class PaintersPartition {
    static long minTime(long[] boards, int painters) {
        long l = 0, r = 0;

        for (long b : boards) {
            l = Math.max(l, b);
            r += b;
        }

        long result = r;

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (isPossible(boards, painters, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    static boolean isPossible(long[] boards, int painters, long maxTime) {
        int usedPainters = 1;
        long currentLoad = 0;

        for (long length : boards) {
            if (currentLoad + length <= maxTime) {
                currentLoad += length;
            } else {
                usedPainters++;
                currentLoad = length;
                if (usedPainters > painters) {
                    return false;
                }
            }
        }
        return true;
    }
}
