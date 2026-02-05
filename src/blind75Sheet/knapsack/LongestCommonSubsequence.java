package blind75Sheet.knapsack;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        // Test Case 1
        String s1_1 = "abcde", s1_2 = "ace";
        int result1 = obj.longestCommonSubsequence(s1_1, s1_2);
        System.out.println("String 1=" + s1_1 + ", String 2=" + s1_2 + ", result=" + result1);

        // Test Case 2
        String s2_1 = "abc", s2_2 = "abc";
        int result2 = obj.longestCommonSubsequence(s2_1, s2_2);
        System.out.println("String 1=" + s2_1 + ", String 2=" + s2_2 + ", result=" + result2);

        // Test Case 3
        String s3_1 = "abc", s3_2 = "def";
        int result3 = obj.longestCommonSubsequence(s3_1, s3_2);
        System.out.println("String 1=" + s3_1 + ", String 2=" + s3_2 + ", result=" + result3);
    }

    /**
     * Approach: Memoization
     * TC: O(m x n)
     * SC: O(m x n)
     *
     * @param text1
     * @param text2
     * @return integer value denoting longest common subsequence
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
