package Recursion.SubsetBased;
/*
 * Question:
 * Solve the 0/1 knapsack problem to maximize value within the given capacity.
 */
public class Knapsack {

    static int knapsack(int[] weights, int[] values, int n, int capacity) {

        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (weights[n - 1] > capacity) {
            return knapsack(weights, values, n - 1, capacity);
        }

        int include = values[n - 1] + knapsack(weights, values, n - 1, capacity - weights[n - 1]);
        int exclude = knapsack(weights, values, n - 1, capacity);

        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4};
        int[] values = {3, 4, 5};
        int capacity = 5;

        System.out.println(knapsack(weights, values, weights.length, capacity));
    }
}
