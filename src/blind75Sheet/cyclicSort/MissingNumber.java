package blind75Sheet.cyclicSort;

public class MissingNumber {

    public static void main(String[] args) {
        System.out.println("[3,0,1] = " + missingNumber(new int[]{3, 0, 1})); // Output : 2
        System.out.println("[0,1] = " + missingNumber(new int[]{0, 1})); // Output : 2
        System.out.println("[9,6,4,2,3,5,7,0,1] = " + missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})); // Output : 8
    }

    /**
     * Finds the missing number in an array using the mathematical formula.
     * <p>
     * The sum of the first n natural numbers is n * (n + 1) / 2.
     * The missing number is the difference between the expected sum and the actual sum of the array.
     *
     * @param nums An array of size n containing distinct integers in the range [0, n],
     *             with exactly one number missing.
     * @return The missing number in the range [0, n].
     */
    public static int missingNumber(int[] nums) {
        int expectedSum = (nums.length * (nums.length + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        // The difference is the missing number
        return expectedSum - actualSum;
    }

    /**
     * Time Complexity: O(n) - single pass to compute the actual sum.
     * Space Complexity: O(1) - no additional space used.
     */

    /**
     * Alternate Solution:
     * Finds the missing number in an array containing distinct numbers from 0 to n.
     * <p>
     * This method first sorts the array and then checks for the first index i
     * where nums[i] != i. That index represents the missing number.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(1) - sorting is done in place.
     */
//    public int missingNumber(int[] nums) {
//        Arrays.sort(nums);  // Sort the array to bring elements in order
//        int n = nums.length;
//
//        // Iterate and find the index where the value does not match the index
//        for (int i = 0; i < n; i++) {
//            if (i != nums[i]) {
//                return i;  // Missing number found
//            }
//        }
//
//        // If all indices match, then the missing number is 'n'
//        return n;
//    }
// Or we can break from the if inside the loop and return i after the loop.
}
