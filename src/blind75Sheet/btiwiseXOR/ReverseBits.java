package blind75Sheet.btiwiseXOR;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();

        // Test Case 1
        int n1 = 43261596;
        int result1 = obj.reverseBits(n1);
        System.out.println("n1=" + n1 + ", result=" + result1);

        // Test Case 2
        int n2 = 2147483644;
        int result2 = obj.reverseBits(n2);
        System.out.println("n2=" + n2 + ", result=" + result2);
    }

    /**
     * Reverses the bits of a 32-bit integer.
     * <p>
     * The method reads bits from the right (least significant bit) of the input
     * number and places them from the left (most significant bit) in the result.
     * <p>
     * Since Java does not have an unsigned int type, the input is treated as
     * unsigned at the bit level. The internal binary representation remains
     * the same for signed and unsigned integers.
     *
     * @param n the input integer whose bits need to be reversed
     * @return an integer formed by reversing all 32 bits of the input
     */
    public int reverseBits(int n) {
        int res = 0;

        // We process exactly 32 bits
        for (int shift = 31; shift >= 0; shift--) {
            int bit = n & 1; // extract the last bit
            res |= (bit << shift); // place it in the reversed position
            n = n >> 1; // move to the next bit
        }

        return res;
    }
}

/**
 * TC= O(32) -> Constant time
 * SC= O(1) -> No extra space needed
 */