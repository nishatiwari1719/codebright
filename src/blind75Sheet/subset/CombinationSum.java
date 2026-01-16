package blind75Sheet.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();

        // Test Case 1
        int[] nums1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = obj.combinationSum(nums1, target1);
        System.out.println("nums1=" + Arrays.toString(nums1) + ", target1=" + target1 + ", output=" + result1);

        // Test Case 2
        int[] nums2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = obj.combinationSum(nums2, target2);
        System.out.println("nums2=" + Arrays.toString(nums2) + ", target2=" + target2 + ", output=" + result2);

        // Test Case 3
        int[] nums3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = obj.combinationSum(nums3, target3);
        System.out.println("nums3=" + Arrays.toString(nums3) + ", target3=" + target3 + ", output=" + result3);
    }

    /**
     * Finds all combinations of numbers that sum up to the target.
     * Each number can be used multiple times.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates); // sort to avoid duplicate combinations
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    /**
     * Uses backtracking to build combinations.
     *
     * @param list     final list of valid combinations
     * @param tempList current combination being built
     * @param nums     input numbers
     * @param remain   remaining sum to reach target
     * @param start    index to start choosing numbers from
     */
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,
                           int remain, int start) {
        // If remaining sum is negative, stop this path
        if (remain < 0) {
            return;
        }
        // If remaining sum is zero, we found a valid combination
        if (remain == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        // Try all numbers starting from 'start'
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/**
 * | Complexity Type  | Value                                           |
 * | ---------------  | ----------------------------------------------- |
 * | Time Complexity  | **Exponential** → `O(n^(target / min(nums)))`   |
 * | Space Complexity | **Exponential** → `O(n^(target / min(nums)))`   |
 * <p>
 * Time Complexity is exponential because we generate all possible valid combinations.
 * Space Complexity is exponential because we store all possible valid combinations.
 */
