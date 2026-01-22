package blind75Sheet.fibonacciNumbers;

public class ClimbingStairsTabulationSoln {
    public static void main(String[] args) {
        ClimbingStairsTabulationSoln obj = new ClimbingStairsTabulationSoln();

        // Test case 1
        int n1 = 2;
        int result1 = obj.climbStairs(n1);
        System.out.println("n1=" + n1 + ", result1=" + result1);

        // Test case 2
        int n2 = 3;
        int result2 = obj.climbStairs(n2);
        System.out.println("n2=" + n2 + ", result2=" + result2);
    }

    /**
     * Tabulation (Bottom-Up DP)
     * <p>
     * Returns the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * <p>
     * This approach uses tabulation (bottom-up dynamic programming) by building
     * the solution from step 0 up to step n using a DP array.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the DP array
     *
     * @param n the total number of steps
     * @return the number of distinct ways to reach step n
     */

    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Ways from previous two steps
        }

        return dp[n];
    }
}
