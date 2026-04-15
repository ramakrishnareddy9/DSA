package GreedyAlgorithms;

public class IndianCoinChange {

    static int coinChange(int coins[], int money) {

        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] <= money) {
                int use = money / coins[i];
                money -= use * coins[i];
                count += use;
                for (int j = 0; j < use; j++) {
                    System.out.print(coins[i] + " ");
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

        int money = 39;

        System.out.println("Coins used:");
        int result = coinChange(coins, money);

        System.out.println("\nTotal coins: " + result);
    }
}