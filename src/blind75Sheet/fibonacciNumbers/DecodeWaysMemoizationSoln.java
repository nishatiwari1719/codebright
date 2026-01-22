package blind75Sheet.fibonacciNumbers;

public class DecodeWaysMemoizationSoln {
    public static void main(String[] args) {
        DecodeWaysMemoizationSoln obj = new DecodeWaysMemoizationSoln();

        // Test Case 1
        String s1 = "12";
        int result1 = obj.numDecodings(s1);
        System.out.println("s1=" + s1 + ", result1=" + result1);

        // Test Case 2
        String s2 = "226";
        int result2 = obj.numDecodings(s2);
        System.out.println("s2=" + s2 + ", result2=" + result2);

        // Test Case 3
        String s3 = "06";
        int result3 = obj.numDecodings(s3);
        System.out.println("s3=" + s3 + ", result3=" + result3);
    }

    /**
     * Returns the number of ways to decode a numeric string where
     * '1' -> 'A', '2' -> 'B', ..., '26' -> 'Z'.
     * <p>
     * Uses dynamic programming where dp[i] stores the number of ways
     * to decode the first i characters of the string.
     * <p>
     * Time Complexity: O(n), as we traverse over the string once
     * Space Complexity: O(n), as we use memoization array
     */
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigits = Integer.valueOf(s.substring(i - 2, i));

            if (oneDigit >= 1) {
                dp[i] = dp[i] + dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[n];
    }
}
