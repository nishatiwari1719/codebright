package blind75Sheet.fibonacciNumbers;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumbersMemoizationSoln {
    public static void main(String[] args) {
        FibonacciNumbersMemoizationSoln obj = new FibonacciNumbersMemoizationSoln();

        // Test case 1
        int n1 = 2;
        int result1 = obj.climbStairs(n1);
        System.out.println("n1=" + n1 + ", result1=" + result1);

        // Test case 2
        int n2 = 3;
        int result2 = obj.climbStairs(n2);
        System.out.println("n2=" + n2 + ", result2=" + result2);
    }

    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return climbStairs(n, map);
    }

    private int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (!map.containsKey(n)) {
            map.put(n, climbStairs(n - 1, map) + climbStairs(n - 2, map));
        }

        return map.get(n);
    }
}
