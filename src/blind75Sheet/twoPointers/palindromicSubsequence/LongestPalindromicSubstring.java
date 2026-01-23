package blind75Sheet.twoPointers.palindromicSubsequence;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

        // Test Case 1
        String s1 = "babad";
        String result1 = obj.longestPalindrome(s1);
        System.out.println("s1=" + s1 + ", result1=" + result1);

        // Test Case 2
        String s2 = "cbbd";
        String result2 = obj.longestPalindrome(s2);
        System.out.println("s2=" + s2 + ", result2=" + result2);
    }

    /**
     * Approach:
     * We need to shift a start point one by one to check longest palindromic substring.
     * <p>
     * What is the start point?
     * Since palindromic substring is like a mirror from some character, it's good idea to consider current index as
     * a center of palindromic substring and expand left and right at the same time.
     *
     * @param s string to check palindrome
     * @return substring which is a palindrome
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expandAroundCenter(s, i, i);
            int even = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(odd, even);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

/**
 * TC= O(n^2), because the code uses nested loops
 * <p>
 * SC= O(1), the code uses a constant amount of extra space for variables like "start," "end," "left," "right,"
 * and function parameters. The space used does not depend on the size of the input string.
 */