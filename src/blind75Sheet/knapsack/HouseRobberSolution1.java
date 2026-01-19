package blind75Sheet.knapsack;

import java.util.Arrays;

public class HouseRobberSolution1 {
    public static void main(String[] args) {
        HouseRobberSolution1 obj = new HouseRobberSolution1();

        // Test Case 1
        int[] n1 = new int[]{1, 2, 3, 1};
        int result1 = obj.rob(n1);
        System.out.println("n1=" + Arrays.toString(n1) + ", result1=" + result1);

        // Test Case 2
        int[] n2 = new int[]{2, 7, 9, 3, 1};
        int result2 = obj.rob(n2);
        System.out.println("n2=" + Arrays.toString(n2) + ", result2=" + result2);
    }

    /**
     * Solution 1: Dynamic Programming with an Array
     *
     * Key Observations:
     * If a thief robs house i, they cannot rob house i-1 due to the constraints.
     * If the thief skips house i, their maximum profit up to house i is the same as the profit for house i-1.
     * <p>
     * State Transition:
     * The thief has two options at house i:
     * Skip the house: Maximum profit is the same as the previous house, dp[i-1].
     * Rob the house: Add the value of the house to the profit two houses back, nums[i] + dp[i-2].
     * <p>
     * Thus, the recurrence relation is:
     * dp[i] = max(dp[i-1], nums[i] + dp[i-2])
     * <p>
     * Base Cases:
     * If there is only one house, the maximum profit is simply nums[0].
     * For two houses, take the maximum value between the two: max(nums[0], nums[1]).
     *
     * @param nums amount of money of each house
     * @return maximum amount of money
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if (n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }
}

/**
 * Time Complexity: O(n) — A single loop processes all houses.
 * Space Complexity: O(n) — The dp array stores results for all houses.
 */