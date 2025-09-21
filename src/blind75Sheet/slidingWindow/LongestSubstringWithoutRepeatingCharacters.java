package blind75Sheet.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println("abcabcbb = " + obj.lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println("bbbbb = " + obj.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println("pwwkew = " + obj.lengthOfLongestSubstring("pwwkew")); //3
        System.out.println("abba = " + obj.lengthOfLongestSubstring("abba")); //2
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
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
            }
            charMap.put(s.charAt(right), right);
        }
        return maxLength;
    }

//    ------------------------------------------------------------------------------------------------------------------
//    Second Best/Alternate Optimised approach:
    /**
     * The method maintains a dynamic window [left, right) and expands it by adding
     * characters to a HashSet. When a duplicate is found, it shrinks the window
     * from the left until the duplicate is removed.
     * <p></p>
     * This approach is a bit more intuitive but slightly slower in practice (because it may
     * remove multiple characters from the set one by one).
     * The HashMap version is preferred in most interviews
     *
     * @param s The input string to evaluate.
     * @return The length of the longest substring without repeating characters.
     *
     * <p><b>Time Complexity:</b> O(n), where n is the length of the string.</p>
     * <p><b>Space Complexity:</b> O(min(n, m)), where m is the size of the character set.</p>
     */
//    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int left = 0, right = 0, maxLength = 0;
//
//        while (right < s.length()) {
//            if (!set.contains(s.charAt(right))) {
//                set.add(s.charAt(right++));
//                maxLength = Math.max(maxLength, right - left);
//            } else {
//                set.remove(s.charAt(left++));
//            }
//        }
//
//        return maxLength;
//    }

//    ------------------------------------------------------------------------------------------------------------------
//    Brute Force:
    /**
     * This method checks all possible substrings of the input string and determines
     * the longest one that contains all unique characters. For each substring,
     * a HashSet is used to track characters and detect duplicates.
     *
     * @param s The input string to evaluate.
     * @return The length of the longest substring without repeating characters.
     *
     * <p><b>Time Complexity:</b> O(n²), where n is the length of the string.</p>
     * <p><b>Space Complexity:</b> O(min(n, m)), where m is the size of the character set
     * (e.g., 26 for lowercase English letters).</p>
     */
//    public int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            Set<Character> seen = new HashSet<>();
//            for (int j = i; j < s.length(); j++) {
//                if (seen.contains(s.charAt(j))) {
//                    break;
//                }
//                seen.add(s.charAt(j));
//                maxLength = Math.max(maxLength, j - i + 1);
//            }
//        }
//        return maxLength;
//    }


}
