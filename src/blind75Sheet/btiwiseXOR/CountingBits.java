package blind75Sheet.btiwiseXOR;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        CountingBits obj = new CountingBits();

        // Test Case 1
        int n1 = 2;
        int[] result1 = obj.countBits(n1);
        System.out.println("n1=" + n1 + ", result=" + Arrays.toString(result1));

        // Test Case 2
        int n2 = 5;
        int[] result2 = obj.countBits(n2);
        System.out.println("n2=" + n2 + ", result=" + Arrays.toString(result2));
    }

    /**
     * Returns an array where each index i contains the number of set bits (1s)
     * in the binary representation of i, for all values from 0 to n (inclusive).
     *
     * <p>
     * This uses a dynamic programming approach based on the observation that:
     * <ul>
     *   <li>i >> 1 removes the least significant bit of i</li>
     *   <li>i & 1 indicates whether i is odd (last bit is 1)</li>
     * </ul>
     * Hence, the number of set bits in i can be derived from a smaller
     * previously computed value.
     * </p>
     *
     * @param n the upper bound (inclusive) for which set bits are counted
     * @return an array of size n + 1 where ans[i] is the count of set bits in i
     */
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}

/**
 * | Metric           | Correct Value | Reason                    |
 * | ---------------- | ------------- | ------------------------- |
 * | Time Complexity  | **O(n)**      | Loop runs `n` times       |
 * | Space Complexity | **O(n)**      | Output array size `n + 1` |
 */