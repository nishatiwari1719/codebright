package blind75Sheet.twoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println("[2,7,11,15], 9 = " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); //"BANC"
        System.out.println("[3, 2, 4], 6 = " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); //"a"
        System.out.println("[3, 3], 6 = " + Arrays.toString(twoSum(new int[]{3, 3}, 6))); //""
    }

    public static int[] twoSum(int[] nums, int target) {
        //most optimised solution - best case O(n) - One-pass Hash Table
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

/**
 * Most optimised solution - Time and Space complexity analysis:
 * TIME COMPLEXITY = O(n)
 * SPACE COMPLEXITY = O(n)
 *
 * We are using a HashMap to store up to n elements from the array (nums[i] as key and i as value).
 * In the worst case, where no solution is found until the last iteration, we will store all n numbers in the map.
 * So, space complexity = O(n) due to the auxiliary space used by the map.
 *
 * Can there be O(1) Space Complexity in any case?
 * O(1) space would mean no additional space is used that grows with input size — e.g., only a few variables or counters.
 * The brute force approaches at the bottom of our code that use just a result[] = new int[2]; and two loops do have
 * O(1) space complexity (though their time complexity is O(n²)).
 *
 * | Approach         | Time Complexity | Space Complexity |
 * | ---------------- | --------------- | ---------------- |
 * | One-pass HashMap | O(n)            | O(n)             |
 * | Two-pass HashMap | O(n)            | O(n)             |
 * | Brute-force      | O(n²)           | O(1)             |
 */

//optimised.. time comp is O(n) but we have compromised space for time - Two-pass Hash Table
/*        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++)
        {
            int complement = target-nums[i];
            if(map.containsKey(complement) && map.get(complement) != i)
            {
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }
        }//end of for
            return result;*/


//brute force approach - worst O(n^2)
        /*int result[] = new int[2];
        for(int i=0; i<nums.length-1; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;*/


//my first approach - worst O(n^2)
/* int result[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    result[0]=j;
                    result[1]=i;
                    break;
                }
            }
        }
        return result;*/
