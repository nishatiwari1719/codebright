package blind75Sheet.knapsack;

import java.util.Arrays;

public class HouseRobber2Solution {
    public static void main(String[] args) {
        HouseRobber2Solution obj = new HouseRobber2Solution();

        // Test Case 1
        int[] n1 = new int[]{2, 3, 2};
        int result1 = obj.rob(n1);
        System.out.println("n1=" + Arrays.toString(n1) + ", result1=" + result1);

        // Test Case 2
        int[] n2 = new int[]{1, 2, 3, 1};
        int result2 = obj.rob(n2);
        System.out.println("n2=" + Arrays.toString(n2) + ", result2=" + result2);

        // Test Case 3
        int[] n3 = new int[]{1, 2, 3};
        int result3 = obj.rob(n3);
        System.out.println("n3=" + Arrays.toString(n3) + ", result3=" + result3);
    }

    /**
     * To make the question easy, strategy is to eliminate the first house or the last house,
     * because we can't rob the first house and the last house at the same time, so possible cases should be:
     * the first house in and the last house out
     * or
     * the first house out and the last house in
     * <p>
     * first try, we calculate max money with [2,7,9,3](= Eliminate the last house)
     * In the second try, we calculate max money with [7,9,3,1](= Eliminate the first house)
     * <p>
     * In addition to this, if we have only one house such as [2], then we return its value.
     * Hence, we have three cases.
     *
     * @param nums amount of money of each house
     * @return maximum amount of money
     */
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }


    int getMax(int[] nums, int start, int end) {
        int prevProfit = 0, maxProfit = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxProfit, prevProfit + nums[i]);
            prevProfit = maxProfit;
            maxProfit = temp;
        }
        return maxProfit;
    }
}

/**
 * Time Complexity: O(n) — A single loop processes all houses.
 * Space Complexity: O(n) — The dp array stores results for all houses.
 */