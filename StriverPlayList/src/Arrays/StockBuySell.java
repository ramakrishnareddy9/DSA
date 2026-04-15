package Arrays;

public class StockBuySell {
    static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int current = prices[0];
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < current){
                current = prices[i];
            }
            maxProfit = Math.max(maxProfit,prices[i] - current);
        }
        return maxProfit;
    }
}