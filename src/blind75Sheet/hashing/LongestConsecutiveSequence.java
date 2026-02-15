package blind75Sheet.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();

        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int result1 = obj.longestConsecutive(nums1);
        System.out.println("nums=" + Arrays.toString(nums1) + ", result=" + result1);

        // Test Case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int result2 = obj.longestConsecutive(nums2);
        System.out.println("nums=" + Arrays.toString(nums2) + ", result=" + result2);

        // Test Case 3
        int[] nums3 = {1, 0, 1, 2};
        int result3 = obj.longestConsecutive(nums3);
        System.out.println("nums=" + Arrays.toString(nums3) + ", result=" + result3);
    }

    /**
     * TC=O(n), SC=O(n)
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
