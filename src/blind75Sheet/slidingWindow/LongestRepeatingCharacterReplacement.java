package blind75Sheet.slidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println("ABAB = " + obj.characterReplacement("ABAB", 2)); //4
        System.out.println("AABABBA = " + obj.characterReplacement("AABABBA", 1)); //4
        System.out.println("ABAA = " + obj.characterReplacement("ABAA", 0)); //2
    }

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update the frequency of the current character
            freq[s.charAt(right) - 'A']++;

            // Update the max frequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // Find the current window length
            int windowLength = right - left + 1;

            // If windowLength - maxFreq > k,
            // then we need to shrink the window
            if (windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Recompute window length
            windowLength = right - left + 1;

            // Compute maximum window length
            maxWindow = Math.max(maxWindow, windowLength);
        }
        return maxWindow;
    }

    /**
     * TIME and SPACE COMPLEXITY => O(n) and O(1) respectively.
     */
}
