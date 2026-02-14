package blind75Sheet.prefixSuffix;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf obj = new ProductOfArrayExceptSelf();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = obj.productExceptSelf(nums1);
        System.out.println("nums=" + Arrays.toString(nums1) + ", result=" + Arrays.toString(result1)); // [24,12,8,6]

        // Test Case 2
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] result2 = obj.productExceptSelf(nums2);
        System.out.println("nums=" + Arrays.toString(nums2) + ", result=" + Arrays.toString(result2)); // [0,0,9,0,0]
    }

    /**
     * Most Optimized Approach: Directly store the product of prefix and suffix into the final answer array
     * TC=O(n), SC=O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

    // Approach: Prefix Product and Suffix Product
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] pre = new int[n];
//        int[] suff = new int[n];
//        pre[0] = 1;
//        suff[n - 1] = 1;
//
//        for (int i = 1; i < n; i++) {
//            pre[i] = pre[i - 1] * nums[i - 1];
//        }
//
//        for (int i = n - 2; i >= 0; i--) {
//            suff[i] = suff[i + 1] * nums[i + 1];
//        }
//
//        int[] ans = new int[n];
//        for (int i = 0; i < n; i++) {
//            ans[i] = pre[i] * suff[i];
//        }
//
//        return ans;
//    }

    // Approach: Dividing the product of array with the number, TC=O(n), SC=O(1)
    // This will throw ArithmeticException: / by zero
//        public int[] productExceptSelf(int[] nums) {
//            int n = nums.length;
//            int[] ans = new int[n];
//            int product = 1;
//            for (int i : nums) {
//                product *= i;
//            }
//            for (int i = 0; i < n; i++) {
//                ans[i] = product / nums[i];
//            }
//            return ans;
//        }

    // Approach: Brute Force, TC=O(n^2), SC=O(1)
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        for (int i = 0; i < n; i++) {
//            int product = 1;
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                }
//                product *= nums[j];
//            }
//            ans[i] = product;
//        }
//        return ans;
//    }
}
