package blind75Sheet.twoPointers;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks obj = new BestTimeToBuyAndSellStocks();

        System.out.println("[7,1,5,3,6,4] = " + obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println("[7,6,4,3,1] = " + obj.maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

    /**
     * Finds the maximum profit from a single buy and a single sell of a stock.
     * <p>
     * We must always buy before we sell. So while moving from left to right,
     * this method keeps track of the lowest price seen so far as the buying price.
     * <p>
     * For each new day, we imagine selling the stock on that day and calculate
     * how much profit we would make using the best buying price from the past.
     * If this profit is better than what we have seen before, we update the answer.
     * <p>
     * If prices only go down, no profit is possible and the method returns 0.
     *
     * @param prices array where prices[i] is the stock price on day i
     * @return the maximum profit possible from one buy and one sell
     */
    public int maxProfit(int[] prices) {
        int buyingPrice = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyingPrice;
                profit = Math.max(currentProfit, profit);
            }
        }
        return profit;
    }
}

/**
 * TC= O(n)
 * SC= O(1)
 */