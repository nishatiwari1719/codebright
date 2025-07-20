package blind75Sheet.slidingWindow;

public class MinimumWindowSubstringFrequencyArray {
    public static void main(String[] args) {
        MinimumWindowSubstringFrequencyArray obj = new MinimumWindowSubstringFrequencyArray();

        System.out.println("ADEBANC, ABC = " + obj.minWindow("ADEBANC", "ABC")); //"BANC"
        System.out.println("ADOBECODEBANC, ABC = " + obj.minWindow("ADOBECODEBANC", "ABC")); //"BANC"
        System.out.println("a, a = " + obj.minWindow("a", "a")); //"a"
        System.out.println("a, aa = " + obj.minWindow("a", "aa")); //""
    }

    /**
     * Finds the minimum window in the string s which will contain all the characters in string t.
     *
     * <p>This implementation uses a sliding window approach with a fixed-size frequency array (assuming ASCII characters)
     * to efficiently track character occurrences. It attempts to expand the right boundary of the window until all
     * required characters are included, and then contracts from the left to find the smallest valid window.</p>
     *
     * @param s the source string in which to find the window
     * @param t the target string containing characters that need to be present in the window
     * @return the minimum window substring of s that contains all characters from t;
     * returns an empty string if no such window exists
     */
    public String minWindow(String s, String t) {
        // If source string is smaller than target, no window is possible
        if (s.length() < t.length()) {
            return "";
        }

        int[] count = new int[128]; // Frequency array for ASCII characters

        // Initialize frequency array based on characters in t
        for (char ch : t.toCharArray()) {
            count[ch]++;
        }

        int left = 0; // Left pointer of the sliding window
        int minStart = 0; // Start index of the minimum window
        int minLen = Integer.MAX_VALUE; // Length of the minimum window
        int targetCharsRemaining = t.length(); // Total number of target characters to match

        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);

            // If this character is needed (its count > 0), it contributes to matching
            if (count[rChar] > 0) {
                targetCharsRemaining--;
            }

            // Decrease count (whether needed or extra, to track window state)
            count[rChar]--;

            // Once all characters are matched
            if (targetCharsRemaining == 0) {
                // Try to shrink window from the left
                while (true) {
                    char lChar = s.charAt(left);
                    if (count[lChar] == 0) {
                        break; // Can't remove this char, it's needed
                    }
                    count[lChar]++; // Give back unused/extra character
                    left++;
                }

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minStart = left;
                    minLen = right - left + 1;
                }

                // Move left pointer to look for next valid window
                count[s.charAt(left)]++; // This character is no longer part of the window
                targetCharsRemaining++; // We need this char again
                left++;
            }
        }

        // Return the result based on whether we found a valid window
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /**
     * Time Complexity: O(m + n), where m = s.length() and n = t.length()
     *   - Each character is visited at most twice (once by right, once by left).
     * Space Complexity: O(1)
     *   - Only a fixed-size array of 128 (ASCII) characters is used, regardless of input size.
     */

    /**
     * Q. Why is the solution using Frequency Array approach better than the Map based approach?
     *
     * This comparison applies when both strings contain only ASCII characters (e.g., English letters).
     * If the input includes Unicode, HashMaps might become necessary.
     *
     * | Aspect           | Frequency Array                    | HashMap                                               |
     * | ---------------- | ---------------------------------- | ----------------------------------------------------- |
     * | Time complexity  | O(1) access & update (array index) | O(1) on average, but involves hashing and may degrade |
     * | Space efficiency | Fixed size (typically 128 or 256)  | Dynamic, can grow based on character set              |
     * | Character set    | Best for fixed-size (ASCII)        | Supports any character set, including Unicode         |
     *
     * Advantages of Frequency Array:
     * 1) Fast constant-time operations:
     * Getting or updating a character count is just a direct array access.
     * No hashing, no boxing/unboxing of characters, no handling of key collisions.
     * 2) Lower space usage:
     * For ASCII, int[128] is enough. Compared to a HashMap, it uses less memory and avoids internal rehashing or resizing.
     * 3) Cleaner and faster execution:
     * Avoids object creation — maps require wrapper objects for keys (Character) and values (Integer).
     * In performance-critical problems (e.g., competitive programming), this can make a difference.
     *
     * Summary:
     * If the question involves basic English letters or known character sets → use a Frequency Array.
     * If the character set is unknown or large → use a HashMap.
     */
}
