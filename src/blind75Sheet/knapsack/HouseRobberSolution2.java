package blind75Sheet.knapsack;

import java.util.Arrays;

public class HouseRobberSolution2 {
    public static void main(String[] args) {
        HouseRobberSolution2 obj = new HouseRobberSolution2();

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
     * Solution 2: Optimized Space Dynamic Programming
     * <p>
     * In Solution 1, we used an array dp to store results for all houses. However, only the last two values in
     * the dp array are needed at any time. This insight allows us to reduce space complexity by using two variables
     * to track these values.
     * <p>
     * Variables:
     * prev_rob: Maximum profit if the thief robs up to house i-2.
     * max_rob: Maximum profit if the thief robs up to house i-1.
     * <p>
     * Transition:
     * At each house, calculate the maximum profit:
     * temp = max(max_rob, prev_rob + nums[i])
     * Then update the variables
     *
     * @param nums amount of money of each house
     * @return maximum amount of money
     */
    public int rob(int[] nums) {
        int prevProfit = 0, maxProfit = 0;

        for (int currentValue : nums) {
            int temp = Math.max(maxProfit, prevProfit + currentValue);
            prevProfit = maxProfit;
            maxProfit = temp;
        }

        return maxProfit;
    }
}

/**
 * Time Complexity: O(n) — A single loop processes all houses.
 * Space Complexity: O(1) — Only two variables are used.
 */