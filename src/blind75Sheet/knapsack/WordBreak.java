package blind75Sheet.knapsack;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak obj = new WordBreak();

        List<String> list1 = new ArrayList<>(Arrays.asList("leet", "code"));
        String s1 = "leetcode";
        boolean result1 = obj.wordBreak(s1, list1);
        System.out.println("list1 = " + list1 + ", s1 = " + s1 + ", result = " + result1);
        System.out.println();

        List<String> list2 = new ArrayList<>(Arrays.asList("apple", "pen"));
        String s2 = "applepenapple";
        boolean result2 = obj.wordBreak(s2, list2);
        System.out.println("list2 = " + list2 + ", s2 = " + s2 + ", result = " + result2);
        System.out.println();

        List<String> list3 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        String s3 = "catsandog";
        boolean result3 = obj.wordBreak(s3, list3);
        System.out.println("list3 = " + list3 + ", s3 = " + s3 + ", result = " + result3);
        System.out.println();
    }

    /**
     * Approach: Memoization (DP)
     * TC: O(n^2)
     * SC: O(n)
     *
     * @param s
     * @param wordDict
     * @return true if s can be segmented into a space-separated sequence of one or more dictionary words, otherwise false
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
