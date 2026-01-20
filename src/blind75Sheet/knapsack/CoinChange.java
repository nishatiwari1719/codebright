package blind75Sheet.knapsack;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        CoinChange obj = new CoinChange();

        // Test Case 1
        int[] n1 = new int[]{1, 2, 5};
        int amount1 = 11;
        int result1 = obj.coinChange(n1, amount1);
        System.out.println("n1=" + Arrays.toString(n1) + ", amount1=" + amount1 + ", result1=" + result1);

        // Test Case 2
        int[] n2 = new int[]{2};
        int amount2 = 3;
        int result2 = obj.coinChange(n2, amount2);
        System.out.println("n2=" + Arrays.toString(n2) + ", amount2=" + amount2 + ", result2=" + result2);

        // Test Case 3
        int[] n3 = new int[]{1};
        int amount3 = 0;
        int result3 = obj.coinChange(n3, amount3);
        System.out.println("n3=" + Arrays.toString(n3) + ", amount3=" + amount3 + ", result3=" + result3);
    }


    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }

        int[] minCoin = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoin[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && minCoin[i - coin] != Integer.MAX_VALUE) {
                    minCoin[i] = Math.min(minCoin[i], 1 + minCoin[i - coin]);
                }
            }
        }

        if (minCoin[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCoin[amount];
        }
    }
}
