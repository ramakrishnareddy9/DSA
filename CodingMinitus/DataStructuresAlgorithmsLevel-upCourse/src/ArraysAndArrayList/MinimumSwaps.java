package ArraysAndArrayList;

import java.util.Arrays;
import java.util.Comparator;

/*
Given an array of size N, find the minimum number of swaps needed to make the array sorted.

Sample Input :
    a1 = [5, 4, 3, 2, 1]
Sample Output :
    2
*/

/*
 * Question:
 * Find the minimum number of swaps required to sort the array.
 */
public class MinimumSwaps {
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int countMinSwaps(int[] arr) {
        int n = arr.length;

        // Store value and original index
        Pair[] ap = new Pair[n];
        for (int i = 0; i < n; i++) {
            ap[i] = new Pair(arr[i], i);
        }

        // Sort based on values
        Arrays.sort(ap, Comparator.comparingInt(p -> p.value));

        // Visited array
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        // Traverse and detect cycles
        for (int i = 0; i < n; i++) {

            // Already visited or already in correct position
            if (visited[i] || ap[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            // Traverse the cycle
            while (!visited[j]) {
                visited[j] = true;
                j = ap[j].index;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }

    // Another way
    static int countMinSwaps2(int[] arr) {
        int n = arr.length;

        // Store value and original index
        int[][] ap = new int[n][2];
        for (int i = 0; i < n; i++) {
            ap[i][0] = arr[i]; // value
            ap[i][1] = i;      // original index
        }

        // Sort based on values
        Arrays.sort(ap, (a, b) -> Integer.compare(a[0], b[0]));

        // Visited array
        boolean[] visited = new boolean[n];

        int swaps = 0;

        // Cycle detection
        for (int i = 0; i < n; i++) {

            // Already visited or already in correct position
            if (visited[i] || ap[i][1] == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = ap[j][1];
                cycleSize++;
            }

            if (cycleSize > 0) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(countMinSwaps(arr)); // Output: 2
    }
}