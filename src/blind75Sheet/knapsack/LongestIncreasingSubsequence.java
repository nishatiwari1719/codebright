package blind75Sheet.knapsack;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        int result1 = obj.lengthOfLIS(nums1); //The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
        System.out.println("nums = " + Arrays.toString(nums1) + ", result = " + result1);
        System.out.println();

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        int result2 = obj.lengthOfLIS(nums2);
        System.out.println("nums = " + Arrays.toString(nums2) + ", result = " + result2);
        System.out.println();

        int[] nums3 = {7, 7, 7, 7, 7, 7, 7};
        int result3 = obj.lengthOfLIS(nums3);
        System.out.println("nums = " + Arrays.toString(nums3) + ", result = " + result3);
    }

    // TC=O(n^2), SC=O(n)
    public int lengthOfLIS(int[] nums) {
        int[] T = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (T[j] + 1 > T[i]) {
                        T[i] = T[j] + 1;
                    }
                }
            }
        }

        int maxIndex = 0;
        for (int i = 0; i < T.length; i++) {
            if (T[i] > T[maxIndex]) {
                maxIndex = i;
            }
        }

        return T[maxIndex] + 1;
    }
}
