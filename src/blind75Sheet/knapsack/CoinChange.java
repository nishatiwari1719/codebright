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

    /**
     * Returns the minimum number of coins needed to make up the given amount.
     * <p>
     * Core Logic (Dynamic Programming):
     * - Use a 1D DP array where minCoin[i] represents the minimum number of coins
     * required to form amount i.
     * - Initialize minCoin[0] = 0 (base case: 0 coins needed to make amount 0).
     * - For each amount i from 1 to amount:
     * - Try every coin value.
     * - If the coin can contribute to amount i (coin <= i) and
     * minCoin[i - coin] is reachable, update:
     * minCoin[i] = min(minCoin[i], 1 + minCoin[i - coin]).
     * - The final answer is minCoin[amount].
     * - If minCoin[amount] is still MAX_VALUE, the amount cannot be formed.
     *
     * @param coins  array of available coin denominations
     * @param amount target amount to form
     * @return minimum number of coins needed, or -1 if not possible
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return 0;
        }

        int[] minCoin = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            minCoin[i] = Integer.MAX_VALUE; // mark as unreachable initially, DP initialization

            for (int coin : coins) {
                if (coin <= i && minCoin[i - coin] != Integer.MAX_VALUE) {
                    // try using current coin to form amount i, DP transition or state transition
                    minCoin[i] = Math.min(minCoin[i], 1 + minCoin[i - coin]);
                }
            }
        }

        if (minCoin[amount] == Integer.MAX_VALUE) {
            return -1; // amount cannot be formed
        } else {
            return minCoin[amount];
        }
    }
}

/**
 * Time Complexity:
 * * - O(amount × n), where n is the number of coin denominations.
 * * - For each amount from 1 to amount, we iterate over all coins once.
 * <p>
 * Space Complexity:
 * * - O(amount), for the DP array minCoin of size amount + 1.
 */