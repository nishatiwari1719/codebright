package blind75Sheet.fibonacciNumbers;

public class FibonacciNumbersSpaceOptimizedSoln {
    public static void main(String[] args) {
        FibonacciNumbersSpaceOptimizedSoln obj = new FibonacciNumbersSpaceOptimizedSoln();

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
        if (n == 0 || n == 1) {
            return 1;
        }

        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }

        return curr;
    }
}
