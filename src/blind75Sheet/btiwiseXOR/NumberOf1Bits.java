package blind75Sheet.btiwiseXOR;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();

        // Test Case 1
        int n1 = 11;
        int result1 = obj.hammingWeight(n1);
        System.out.println("n1=" + n1 + ", result=" + result1);

        // Test Case 2
        int n2 = 128;
        int result2 = obj.hammingWeight(n2);
        System.out.println("n2=" + n2 + ", result=" + result2);

        // Test Case 3
        int n3 = 2147483645;
        int result3 = obj.hammingWeight(n3);
        System.out.println("n3=" + n3 + ", result=" + result3);
    }

    /**
     * Counts the number of set bits (1-bits) in the binary representation
     * of a 32-bit integer.
     *
     * <p>This method examines each of the 32 bits of the integer by:
     * <ul>
     *   <li>Checking the least significant bit using a bitwise AND</li>
     *   <li>Right-shifting the number to process the next bit</li>
     * </ul>
     *
     * <p>The loop always runs 32 times, which ensures correctness for both
     * positive and negative integers in Java (since {@code int} is 32-bit).
     *
     * @param n the integer whose set bits are to be counted
     * @return the number of bits set to 1 in the binary representation of {@code n}
     */
    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}

/**
 * TC= O(1) -> Constant time
 * SC= O(1) -> No extra space needed
 */