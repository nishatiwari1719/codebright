package blind75Sheet;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println("abcabcbb = " + lengthOfLongestSubstring("abcabcbb")); //3
        System.out.println("bbbbb = " + lengthOfLongestSubstring("bbbbb")); //1
        System.out.println("pwwkew = " + lengthOfLongestSubstring("pwwkew")); //3
    }

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
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }
        return maxLength;
    }
}
