package blind75Sheet.modifiedBinarySearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();

        // Test Case 1
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 7;
        int result1 = obj.search(nums1, target1);
        System.out.println("nums1=" + Arrays.toString(nums1) + ", target1=" + target1 + ", output=" + result1);

        // Test Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int result2 = obj.search(nums2, target2);
        System.out.println("nums2=" + Arrays.toString(nums2) + ", target2=" + target2 + ", output=" + result2);

        // Test Case 3
        int[] nums3 = {1};
        int target3 = 0;
        int result3 = obj.search(nums3, target3);
        System.out.println("nums3=" + Arrays.toString(nums3) + ", target3=" + target3 + ", output=" + result3);
    }

    /**
     * Searches for a target value in a rotated sorted array.
     *
     * The array was originally sorted in ascending order but then rotated
     * at some unknown pivot. This method uses a modified binary search
     * to find the target in O(log n) time.
     *
     * @param nums   rotated sorted array of integers
     * @param target value to search for
     * @return index of the target if found, otherwise -1
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                // Target lies within the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right half is sorted
                // Target lies within the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}

/**
 * TC: O(log n)
 * SC: O(1)
 */