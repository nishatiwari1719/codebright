package blind75Sheet.twoHeaps;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        TopKFrequentElements obj = new TopKFrequentElements();

        // Test Case 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] result1 = obj.topKFrequent(nums1, k1);
        System.out.println("nums1=" + Arrays.toString(nums1) + ", k1=" + k1 + ", output=" + Arrays.toString(result1));

        // Test Case 2
        int[] nums2 = {1};
        int k2 = 1;
        int[] result2 = obj.topKFrequent(nums2, k2);
        System.out.println("nums2=" + Arrays.toString(nums2) + ", k2=" + k2 + ", output=" + Arrays.toString(result2));
    }

    /**
     * Returns the k most frequent elements from the array.
     * Uses bucket sort to achieve O(n) time complexity.
     */
    public int[] topKFrequent(int[] nums, int k) {
        // bucket[i] will store all numbers that appear exactly i times
        List<Integer>[] bucket = new List[nums.length + 1];

        // Stores frequency count of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        /**
         * Step 1: Count frequency of each number
         */
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        /**
         * Step 2: Place numbers into buckets based on frequency
         */
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            // Initialize list if this bucket is empty
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int counter = 0;

        /**
         * Step 3: Traverse buckets from highest frequency to lowest
         * and collect k elements
         */
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int i : bucket[pos]) {
                    result[counter++] = i;
                }
            }
        }

        return result;
    }
}
