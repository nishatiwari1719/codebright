package blind75Sheet.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();

        System.out.println("ADEBANC, ABC = " + obj.minWindow("ADEBANC", "ABC")); //"BANC"
        System.out.println("ADOBECODEBANC, ABC = " + obj.minWindow("ADOBECODEBANC", "ABC")); //"BANC"
        System.out.println("a, a = " + obj.minWindow("a", "a")); //"a"
        System.out.println("a, aa = " + obj.minWindow("a", "aa")); //""
    }

    /**
     * Finds the minimum window in 's' which contains all the characters of string 't'.
     *
     * @param s The source string to search within.
     * @param t The target string with characters to match.
     * @return The smallest substring of 's' containing all characters from 't'.
     */
    public String minWindow(String s, String t) {
        // If source string is smaller than target, no window is possible
        if (s.length() < t.length()) {
            return "";
        }

        // Map to store the frequency of characters in 't'
        Map<Character, Integer> charCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        int targetCharsRemaining = t.length(); // Total characters from 't' that still need to be matched
        int[] minWindow = {0, Integer.MAX_VALUE}; // Store start and end index of the minimum window found
        int startIndex = 0; // Start index of current window

        // Iterate over each character in 's' using a sliding window approach
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char ch = s.charAt(endIndex);

            // If the character is in the target and needed, reduce the count of remaining characters
            if (charCount.containsKey(ch) && charCount.get(ch) > 0) {
                targetCharsRemaining--;
            }

            // Decrease frequency of character in the map (even if it's not in target — for balancing when shrinking window)
            charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);

            // When all target characters have been matched in the window
            if (targetCharsRemaining == 0) {
                // Try to shrink the window from the start as much as possible
                while (true) {
                    char charAtStart = s.charAt(startIndex);

                    // If character is needed and its count is zero, we can't remove it
                    if (charCount.containsKey(charAtStart) && charCount.get(charAtStart) == 0) {
                        break;
                    }

                    // Else increase its count and move the start forward
                    charCount.put(charAtStart, charCount.getOrDefault(charAtStart, 0) + 1);
                    startIndex++;
                }

                // Update minimum window if current one is smaller
                if (endIndex - startIndex < minWindow[1] - minWindow[0]) {
                    minWindow[0] = startIndex;
                    minWindow[1] = endIndex;
                }

                // Move start forward to look for a new smaller valid window
                charCount.put(s.charAt(startIndex), charCount.getOrDefault(s.charAt(startIndex), 0) + 1);
                targetCharsRemaining++;
                startIndex++;
            }
        }

        // If no valid window was found, return empty string
        return minWindow[1] >= s.length() ? "" : s.substring(minWindow[0], minWindow[1] + 1);
    }

    /**
     * TIME and SPACE COMPLEXITY => O(m + n) and O(1) respectively.
     * m = s.length(), n = t.length()
     *
     * Why TC is O(n)?
     * We iterate over 't' once to build the frequency map → O(n).
     * We iterate over 's' using sliding window with two pointers (startIndex and endIndex) each moving at most
     * m times → O(m).
     * Hence, total time = O(m + n).
     *
     * Why SC is O(1)?
     * We use a Map<Character, Integer> called charCount. The map stores only characters, and in the worst case it holds:
     * All unique characters in t, and A few extra during processing of s.
     * So, it's O(k) where k is the number of unique characters (from both t and s). But since the character set is bounded
     * (e.g., ASCII has 128 chars, Extended ASCII has 256, Unicode range is also finite), we treat it as O(1) in practice.
     *
     * So yes:
     * Time complexity: O(n)
     * Space complexity: O(1) (assuming character set size is bounded)
     *
     */
}
