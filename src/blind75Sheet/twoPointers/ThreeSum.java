package blind75Sheet.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println("[-1,0,1,2,-1,-4] = " + threeSum(new int[]{-1, 0, 1, 2, -1, -4})); //[[-1, -1, 2], [-1, 0, 1]]
        System.out.println("[0,1,1] = " + threeSum(new int[]{0, 1, 1})); //[]
        System.out.println("[0,0,0] = " + threeSum(new int[]{0, 0, 0})); //[[0, 0, 0]]
    }

    /**
     * Finds all unique triplets in the input array such that the sum of the three numbers is zero.
     *
     * @param nums An integer array of n elements
     * @return A list of lists of unique triplets [nums[i], nums[j], nums[k]] such that i != j != k and nums[i] + nums[j] + nums[k] == 0
     * <p>
     * Time Complexity: O(n^2)
     * - Sorting takes O(n log n)
     * - Outer loop runs n times, and for each i, the two-pointer inner loop takes O(n) → Total: O(n^2)
     * <p>
     * Space Complexity: O(n)
     * - Due to the sorting of input array (depending on sorting algorithm)
     * - Ignoring the space used for output (could be up to O(n^2) in worst case, but often considered separately)
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to apply two-pointer technique and easily skip duplicates
        Arrays.sort(nums);

        // Iterate through the array fixing one number at a time
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate values for i to avoid repeating the same triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;               // Left pointer
            int k = nums.length - 1;     // Right pointer

            // Use two pointers to find two numbers such that their sum with nums[i] is zero
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];
                if (total > 0) {
                    k--; // Sum too large, move right pointer to left
                } else if (total < 0) {
                    j++; // Sum too small, move left pointer to right
                } else {
                    // Found a valid triplet
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    // Skip duplicates for j to avoid repeating the same triplet
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
