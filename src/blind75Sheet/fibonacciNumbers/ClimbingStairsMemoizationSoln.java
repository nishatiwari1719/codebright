package blind75Sheet.fibonacciNumbers;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsMemoizationSoln {
    public static void main(String[] args) {
        ClimbingStairsMemoizationSoln obj = new ClimbingStairsMemoizationSoln();

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
     * Memoization (Top-Down DP)
     * <p>
     * Returns the number of distinct ways to climb to the top of a staircase
     * with n steps, where you can climb either 1 or 2 steps at a time.
     * <p>
     * This approach uses recursion with memoization (top-down dynamic programming)
     * to avoid recalculating results for the same value of n multiple times.
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(n) for recursion stack and memoization map
     *
     * @param n the total number of steps
     * @return the number of distinct ways to reach step n
     */
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1; // Only one way to stand at step 0 or 1
        }

        if (!map.containsKey(n)) {
            // Store the result to avoid recomputation
            map.put(n, climbStairs(n - 1, map) + climbStairs(n - 2, map));
        }

        return map.get(n);
    }
}

/**
 * | Approach                  | Technique          | Time Complexity | Space Complexity | Key Idea                                                     |
 * | ------------------------- | ------------------ | --------------- | ---------------- | ------------------------------------------------------------ |
 * | Memoization (Top-Down DP) | Recursion + Cache  | O(n)            | O(n)             | Store results of subproblems in a map to avoid recomputation |
 * | Tabulation (Bottom-Up DP) | Iterative DP Array | O(n)            | O(n)             | Build solution from 0 to n using a DP array                  |
 * | Space Optimized DP        | Iterative, 2 vars  | O(n)            | O(1)             | Keep only last two values instead of full DP array           |
 */