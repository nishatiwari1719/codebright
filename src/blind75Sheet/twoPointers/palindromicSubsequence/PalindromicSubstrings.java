package blind75Sheet.twoPointers.palindromicSubsequence;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings obj = new PalindromicSubstrings();

        // Test Case 1
        String s1 = "abc";
        int result1 = obj.countSubstrings(s1);
        System.out.println("s1=" + s1 + ", result1=" + result1); // 3

        // Test Case 2
        String s2 = "aaa";
        int result2 = obj.countSubstrings(s2);
        System.out.println("s2=" + s2 + ", result2=" + result2); // 6
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindromes(s, i, i);
            count += countPalindromes(s, i, i + 1);
        }
        return count;
    }

    private int countPalindromes(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

/**
 * TC= O(n^2), because the code uses nested loops
 * SC= O(1), the code uses a constant amount of space
 */