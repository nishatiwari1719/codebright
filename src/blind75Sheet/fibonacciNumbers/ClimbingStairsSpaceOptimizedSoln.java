package blind75Sheet.fibonacciNumbers;

public class ClimbingStairsSpaceOptimizedSoln {
    public static void main(String[] args) {
        ClimbingStairsSpaceOptimizedSoln obj = new ClimbingStairsSpaceOptimizedSoln();

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
     * Returns the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * <p>
     * This approach optimizes space by keeping only the last two computed values
     * instead of using a full DP array.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param n the total number of steps
     * @return the number of distinct ways to reach step n
     * <p>
     */
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr; // Current ways = ways from last two steps
            prev = temp;
        }

        return curr;
    }
}
