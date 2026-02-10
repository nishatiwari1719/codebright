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
        for (int index = nums.length - 2; index >= 0; index--) {
            if (index + nums[index] >= finalPosition) {
                finalPosition = index;
            }
        }
        return finalPosition == 0;
    }
}
