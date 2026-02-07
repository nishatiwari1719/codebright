package blind75Sheet.fibonacciNumbers;

import java.util.Arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();

        // Test Case 1
        int[] nums1 = {2, 3, -2, 4};
        int result1 = obj.maxProduct(nums1);
        System.out.println("nums = " + Arrays.toString(nums1) + ", result = " + result1);
        System.out.println();

        // Test Case 2
        int[] nums2 = {-2, 0, -1};
        int result2 = obj.maxProduct(nums2);
        System.out.println("nums = " + Arrays.toString(nums2) + ", result = " + result2);
        System.out.println();
    }

    /**
     * TC=O(n)
     * SC=O(n)
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // prefix calculation
            leftProduct *= nums[i];

            // suffix calculation
            rightProduct *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return ans;
    }
}
