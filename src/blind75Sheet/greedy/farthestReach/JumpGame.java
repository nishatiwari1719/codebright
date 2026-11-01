package blind75Sheet.greedy.farthestReach;

import java.util.Arrays;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame obj = new JumpGame();

        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        boolean result1 = obj.canJump(nums1);
        System.out.println("nums=" + Arrays.toString(nums1) + ", result=" + result1);

        // Test case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        boolean result2 = obj.canJump(nums2);
        System.out.println("nums=" + Arrays.toString(nums2) + ", result=" + result2);
    }

    /**
     * Approach=Greedy (Farthest Reach), TC=O(n), SC=O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int finalPosition = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= finalPosition) {
                finalPosition = i;
            }
        }
        return finalPosition == 0;
    }

//    Brute Force Approach
//    public boolean canJump(int[] nums) {
//        return canReach(nums, 0);
//    }
//
//    private boolean canReach(int[] nums, int i) {
//        int lastIndex = nums.length - 1;
//
//        // Reached or passed the last i
//        if (i >= lastIndex) {
//            return true;
//        }
//
//        // Cannot move from this i
//        if (nums[i] == 0) {
//            return false;
//        }
//
//        // Try every possible jump
//        int furthest = Math.min(i + nums[i], lastIndex);
//        for (int next = i + 1; next <= furthest; next++) {
//            if (canReach(nums, next)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    Complexity of brute force
//- Time: (O(2^n)) as a commonly quoted upper bound.
//- Auxiliary space: (O(n)) for the recursion stack.
//    Why exponential time? The algorithm may explore many different jump sequences, and multiple paths can revisit
//    the same index i. In the worst case, the number of recursive paths can grow exponentially with array length.
}
