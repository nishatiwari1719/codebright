package blind75Sheet.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("abcabcbb = " + lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println("bbbbb = " + lengthOfLongestSubstring("bbbbb")); //1
        System.out.println("pwwkew = " + lengthOfLongestSubstring("pwwkew")); //3
    }

    /**
     * Returns the length of the longest substring without repeating characters in the given string.
     * Uses a sliding window approach with two pointers and a HashMap to track characters and their indices.
     *
     * @param s The input string to evaluate.
     * @return The length of the longest substring with all unique characters.
     *
     * <p><b>Time Complexity:</b> O(n), where n is the length of the string.</p>
     * <p><b>Space Complexity:</b> O(1), assuming the character set is of fixed size (e.g., ASCII).</p>
     */
    public static int lengthOfLongestSubstring(String s) {
        // TC = O(n), SC = O(1)
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            }
            /**
             * This first line inside else block is executed when we encounter a repeating character that is inside
             * the current sliding window.
             * It moves the left pointer just after the last index of the repeated character.
             * This ensures: The new window starts after the previous occurrence of the repeating character.
             * So the new window contains only unique characters again.
             */
            else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}
