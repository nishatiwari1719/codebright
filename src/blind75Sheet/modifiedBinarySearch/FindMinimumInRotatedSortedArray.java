package blind75Sheet.modifiedBinarySearch;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();

        // Test Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int result1 = obj.findMin(nums1);
        System.out.println("nums1=" + Arrays.toString(nums1) + ", output=" + result1);

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int result2 = obj.findMin(nums2);
        System.out.println("nums2=" + Arrays.toString(nums2) + ", output=" + result2);

        // Test Case 3
        int[] nums3 = {11, 13, 15, 17};
        int result3 = obj.findMin(nums3);
        System.out.println("nums3=" + Arrays.toString(nums3) + ", output=" + result3);
    }

    /**
     * Finds the minimum element in a rotated sorted array with no duplicates.
     * <p>
     * Uses binary search by comparing the middle element with the rightmost element
     * to determine which half contains the minimum.
     * <p>
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums a rotated sorted array
     * @return the minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            // Minimum lies in left half (including mid)
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else { // Minimum lies in right half (excluding mid)
                left = mid + 1;
            }
        }
        return nums[left];
    }
}

/**
 * TC: O(log n)
 * SC: O(1)
 */