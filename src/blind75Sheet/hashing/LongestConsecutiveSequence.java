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
     * Optimal Approach: Using HashSet
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

    // Second best approach: Using sorting
    // Once sorted, we can identify the longest sequence in a single traversal.
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//
//        Arrays.sort(nums);
//        int longest = 1;
//        int current = 1;
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                continue;
//            } else if (nums[i] == nums[i - 1] + 1) {
//                current++;
//            } else {
//                current = 1;
//            }
//            longest = Math.max(longest, current);
//        }
//        return longest;
//    }

    // Brute Force approach
//    public int longestConsecutive(int[] nums) {
//        int longest = 0;
//        for (int num : nums) {
//            int current = num;
//            int currentStreak = 1;
//            while (arrayContains(nums, current + 1)) {
//                current++;
//                currentStreak++;
//            }
//            longest = Math.max(longest, currentStreak);
//        }
//        return longest;
//    }
//
//    private boolean arrayContains(int[] nums, int target) {
//        for (int num : nums) {
//            if (num == target)
//                return true;
//        }
//        return false;
//    }
}
