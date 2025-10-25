package contestPractice.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class SmallestMissingMultipleOfK {

    public static void main(String[] args) {
        SmallestMissingMultipleOfK obj = new SmallestMissingMultipleOfK();

        // Test case 1: nums = [8, 2, 3, 4, 6], k = 2
        int[] nums1 = new int[]{8, 2, 3, 4, 6};
        int k1 = 2;
        int result1 = obj.missingMultiple(nums1, k1);
        System.out.println("nums1: " + Arrays.toString(nums1) + ", k1 = " + k1 + ", result1 = " + result1);

        // Test case 2: nums = [1, 4, 7, 10, 15], k = 5
        int[] nums2 = new int[]{1, 4, 7, 10, 15};
        int k2 = 5;
        int result2 = obj.missingMultiple(nums2, k2);
        System.out.println("nums2: " + Arrays.toString(nums2) + ", k2 = " + k2 + ", result2 = " + result2);

        // Test case 3: nums = [99], k = 99
        int[] nums3 = new int[]{99};
        int k3 = 99;
        int result3 = obj.missingMultiple(nums3, k3);
        System.out.println("nums3: " + Arrays.toString(nums3) + ", k3 = " + k3 + ", result3 = " + result3);

    }

    /**
     * HashSet approach with unbounded for loop.
     * Most optimized solution.
     * TC: O(n)
     * SC: O(n)
     *
     * @param nums
     * @param k
     * @return smallest positive multiple of k that is missing from nums
     */
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums)
            set.add(n);
        for (int i = k; ; i += k)
            if (!set.contains(i))
                return i;
    }

//    /**
//     * Brute force approach using unbounded for loop and Java stream.
//     * Simplest conceptually, but slowest in execution.
//     * Very inefficient — for each multiple, it scans the entire array again.
//     * High overhead from Arrays.stream() (creates a new stream each iteration).
//     * TC: O(n x m)
//     * SC: O(1)
//     *
//     * @param nums
//     * @param k
//     * @return smallest positive multiple of k that is missing from nums
//     */
//    public int missingMultiple(int[] nums, int k) {
//        for (int i = k; ; i += k) {
//            int target = i;
//            if (Arrays.stream(nums).noneMatch(x -> x == target)) {
//                return i;
//            }
//        }
//    }

//    /**
//     * My Initial Brute Force Approach using HashMap.
//     * Slightly less optimal — uses a Map when a Set is enough (extra key-value overhead).
//     * TC: O(n)
//     * SC: O(n)
//     *
//     * @param nums
//     * @param k
//     * @return smallest positive multiple of k that is missing from nums
//     */
//    public int missingMultiple(int[] nums, int k) {
//        int n = nums.length;
//        int multiple = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            map.put(nums[i], nums[i]);
//        }
//
//        int i = 1;
//        while (true) {
//            multiple = k * i;
//            if (!map.containsKey(multiple)) {
//                break;
//            }
//            i++;
//        }
//
//        return multiple;
//    }

//| Rank | Approach                 | Time Complexity | Space Complexity | Why                        |
//| ---- | ------------------------ | --------------- | ---------------- | -------------------------- |
//| 🥇 1 | **HashSet**              | **O(n)**        | **O(n)**         | Fast lookups, clean logic  |
//| 🥈 2 | **HashMap**              | **O(n)**        | **O(n)**         | Works but extra overhead   |
//| 🥉 3 | **Brute Force (Stream)** | **O(n × m)**    | **O(1)**         | Very slow for larger input |
}
